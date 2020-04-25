package cn.cqucc.library.service.student.bo;

import cn.cqucc.library.model.student.Student;
import cn.cqucc.library.service.student.api.ICKStudentApi;
import cn.cqucc.library.service.student.dao.ICKStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:43
 * @Description cn.cqucc.library.service.student.bo
 */
@Service
public class CKStudentBO implements ICKStudentApi {
    @Autowired
    private ICKStudentDAO studentDAO;

    @Override
    public int isExist(String account,String password) {
        return studentDAO.isExist(account,password);
    }

    @Override
    public Student getUserInfo(String account, String password) {
        return studentDAO.getUserInfo(account,password);
    }
}
