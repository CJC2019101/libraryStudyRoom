package cn.cqucc.library.service.student.bo;

import cn.cqucc.library.model.student.Student;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.model.student.resp.StudentInfoResp;
import cn.cqucc.library.model.student.resp.WXLoginInfo;
import cn.cqucc.library.model.student.resp.WxUserResp;
import cn.cqucc.library.service.student.api.ICKStudentApi;
import cn.cqucc.library.service.student.dao.ICKStudentDAO;
import cn.cqucc.library.status.BaseResponse;
import cn.cqucc.library.utils.OkHttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:43
 * @Description cn.cqucc.library.service.student.bo
 */
@Transactional
@Service
public class CKStudentBO implements ICKStudentApi {
    @Autowired
    private ICKStudentDAO studentDAO;

    private String jscode2session_url = "https://api.weixin.qq.com/sns/jscode2session";

    @Value("${wx_app_id}")
    private String appid;

    @Value("${wx_app_secret}")
    private String secret;

    private String grantType = "authorization_code";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse loginUser(WxUserResp wxUser)  {
            BaseResponse response = new BaseResponse();
        System.out.println(wxUser);
        Student student=studentDAO.getUserInfo(wxUser.getSno(),wxUser.getPwd());
        if (student!=null){
            try {
                Assert.notNull(wxUser.getCode(), "用户请求code");
                WXLoginInfo loginJson=new WXLoginInfo();
                String url = jscode2session_url + "?appid=" + appid +
                        "&secret=" + secret + "&js_code=" + wxUser.getCode() + "&grant_type=" + grantType;
                String requestInfo = OkHttpUtil.get(url);
                System.out.println(requestInfo);
                loginJson = JSONObject.parseObject(requestInfo,WXLoginInfo.class);
                Student studentDb= studentDAO.selectStudentByOpenId(loginJson.getOpenid());
                if (studentDb != null && !"".equals(studentDb.getStudentId())){
                    System.out.println("数据库已经存在");
                }else{
                    studentDAO.updateStudentOpenId(loginJson.getOpenid(),wxUser.getSno());
                }
                System.out.println(loginJson);
                response.setData(student);
                response.setCode(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            response.setMsg("密码或者账号错误");
            response.setCode(502);
        }
        return response;
    }


    @Override
    public int isExist(String account,String password) {
        return studentDAO.isExist(account,password);
    }

    @Override
    public Student getUserInfo(String account, String password) {
        return studentDAO.getUserInfo(account,password);
    }

    @Override
    public void resetPassword(CKLibraryUserReq user) {
        studentDAO.resetPassword(user);
    }

    @Override
    public StudentInfoResp getDetailUserInfo(String account) {
        return studentDAO.getDetailUserInfo(account);
    }
}
