package cn.cqucc.library.service.student.dao;

import cn.cqucc.library.model.student.Student;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.model.student.resp.StudentInfoResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:50
 * @Description cn.cqucc.library.service.student.dao
 */
@Mapper
public interface ICKStudentDAO {
    int isExist(@Param(value = "account")String account, @Param(value = "password") String password);

    Student getUserInfo(@Param(value = "account") String account, @Param(value = "password") String password);

    void resetPassword(CKLibraryUserReq user);

    StudentInfoResp getDetailUserInfo(String account);

<<<<<<< HEAD
    void insertStudents(List<Student> students);
=======
    Student selectStudentByOpenId(String openId);

    void updateStudentOpenId(@Param("openId") String openId,@Param("studentId")String studentId);
>>>>>>> 3cb2301f9e76f782a365a2642e243c4137a0423f
}
