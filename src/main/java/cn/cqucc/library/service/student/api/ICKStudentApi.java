package cn.cqucc.library.service.student.api;

import cn.cqucc.library.model.student.Student;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:48
 * @Description cn.cqucc.library.service.student.api
 */
public interface ICKStudentApi {
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
}
