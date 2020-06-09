package cn.cqucc.library.service.student.api;

import cn.cqucc.library.model.student.Student;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.model.student.resp.StudentInfoResp;
import cn.cqucc.library.model.student.resp.WxUserResp;
import cn.cqucc.library.status.BaseResponse;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:48
 * @Description cn.cqucc.library.service.student.api
 */
public interface ICKStudentApi {

    BaseResponse loginUser(WxUserResp wxUser);
    /**
     * @param account
     * @return
     * @Description 判断指定ID的学生是否存在
     */
    int isExist(String account, String password);

    /**
     * 获取用户信息
     *
     * @param account
     * @param password
     */
    Student getUserInfo(String account, String password);

    /**
     * 重置密码
     * @param user
     */
    void resetPassword(CKLibraryUserReq user);

    /**
     * 获取用户信息
     * @param account
     * @return
     */
    StudentInfoResp getDetailUserInfo(String account);
}
