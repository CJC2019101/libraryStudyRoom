package cn.cqucc.library.service.api;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:48
 * @Description cn.cqucc.library.service.api
 */
public interface ICKStudentApi {
    /**
     * @param account
     * @return
     * @Description 判断指定ID的学生是否存在
     */
    int isExist(String account,String password);
}
