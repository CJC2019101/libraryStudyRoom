package cn.cqucc.library.controller.student;

import cn.cqucc.library.model.student.resp.StudentInfoResp;
import cn.cqucc.library.service.student.bo.CKStudentBO;
import cn.cqucc.library.status.BaseResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JianfeiChen
 * @date 2020/4/30 10:30
 * @Description 学生控制层
 */
@Controller
public class ControllerStudent {

    @Autowired
    CKStudentBO studentBO;

    @RequestMapping(value = "/getDetailUserInfo", method = RequestMethod.GET)
    @ApiImplicitParam(paramType = "query", value = "账号", name = "account", required = true)
    @ApiOperation(value = "获取用户详细信息")
    @ResponseBody
    public BaseResponse getDetailUserInfo(@RequestParam String account) {
        BaseResponse response = new BaseResponse();
        StudentInfoResp studentInfo = studentBO.getDetailUserInfo(account);
        if (studentInfo.getUserId() == null || studentInfo.getUserId().equals("")) {
            response.setCode(502);
            response.setMsg("数据库信息不存在");
        } else {
            response.setData(studentInfo);
            response.setCode(200);
        }
        return response;
    }
}
