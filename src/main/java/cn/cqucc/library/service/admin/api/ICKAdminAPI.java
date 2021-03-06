package cn.cqucc.library.service.admin.api;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/7 9:53
 * @Description 城科管理员操作API
 */
public interface ICKAdminAPI {
    int isExist(Admin admin);

    Admin getAdminInfo(String account);

    void resetPassword(CKLibraryUserReq user);

    PageInfo<List> findAllAdmins(Integer pageNumber, String schoolCode);

    int addAdmin(Admin admin);

    public void setAdminIsValid(String account);

    int systemAdminLogin(Admin admin);
}
