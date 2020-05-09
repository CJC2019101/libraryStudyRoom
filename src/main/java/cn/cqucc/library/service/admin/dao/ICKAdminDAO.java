package cn.cqucc.library.service.admin.dao;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/7 9:55
 * @Description cn.cqucc.library.service.admin.dao
 */
@Mapper
public interface ICKAdminDAO {
    int isExist(@Param(value = "account")String account, @Param(value = "password")String password);

    Admin getAdminInfo(@Param(value = "account") String account);

    void resetPassword(CKLibraryUserReq user);

    List<Admin> findAllAdmins();

    void addAdmin(Admin admin);

    void setAdminIsValid(Admin admin);
}
