package cn.cqucc.library.service.admin.dao;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.school.School;
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
    int isExist(Admin admin);

    Admin getAdminInfo(@Param(value = "account") String account);

    void resetPassword(CKLibraryUserReq user);

    List<Admin> findAllAdmins(String schoolCode);

    void addAdmin(Admin admin);

    void setAdminIsValid(Admin admin);

    void addAdmins(List<Admin> admins);

    void updateAdmin(@Param(value = "adminAccount") String adminAccount, @Param(value = "adminName") String adminName);
}
