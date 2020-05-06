package cn.cqucc.library.service.admin.api;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;

/**
 * @author JianfeiChen
 * @date 2020/4/7 9:53
 * @Description 城科管理员操作API
 */
public interface ICKAdminAPI {
    int isExist(String account, String password);

    Admin getAdminInfo(String account);

    void resetPassword(CKLibraryUserReq user);
}
