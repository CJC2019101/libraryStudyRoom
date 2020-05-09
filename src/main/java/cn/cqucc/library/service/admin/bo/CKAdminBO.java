package cn.cqucc.library.service.admin.bo;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.service.admin.api.ICKAdminAPI;
import cn.cqucc.library.service.admin.dao.ICKAdminDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author JianfeiChen
 * @date 2020/4/7 9:55
 * @Description cn.cqucc.library.service.admin.bo
 */
@Service
public class CKAdminBO implements ICKAdminAPI {
    @Autowired
    ICKAdminDAO adminDAO;

    @Override
    public int isExist(String account, String password) {
        return adminDAO.isExist(account, password);
    }

    @Override
    public Admin getAdminInfo(String account) {
        return adminDAO.getAdminInfo(account);
    }

    @Override
    public void resetPassword(CKLibraryUserReq user) {
        adminDAO.resetPassword(user);
    }

    @Override
    public PageInfo<List> findAllAdmins(Integer pageNumber) {
        PageHelper.startPage(pageNumber, 5);
        List<Admin> admins = adminDAO.findAllAdmins();
        return new PageInfo(admins);
    }

    @Override
    public int addAdmin(Admin admin) {
        Admin duplicate = adminDAO.getAdminInfo(admin.getAccount());
        if (duplicate == null || duplicate.getId() == null || ("".equals(duplicate.getId()))) {
            admin.setCreateAt(new Date());
            admin.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            adminDAO.addAdmin(admin);
            return 200;
        } else {
            return 502;
        }
    }

    @Override
    public void setAdminIsValid(String account) {
        Admin admin = new Admin();
        admin.setUpdateAt(new Date());
        admin.setAccount(account);
        adminDAO.setAdminIsValid(admin);
    }
}
