package cn.cqucc.library.service.admin.bo;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.admin.directory.AdminDirectory;
import cn.cqucc.library.model.school.School;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.service.admin.api.ICKAdminAPI;
import cn.cqucc.library.service.admin.dao.ICKAdminDAO;
import cn.cqucc.library.service.school.dao.ISchoolDAO;
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
    @Autowired
    ISchoolDAO schoolDAO;

    @Override
    public int isExist(Admin admin) {
        return adminDAO.isExist(admin);
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
    public PageInfo<List> findAllAdmins(Integer pageNumber, String schoolCode) {
        PageHelper.startPage(pageNumber, 5);
        List<Admin> admins = adminDAO.findAllAdmins(schoolCode);
        return new PageInfo(admins);
    }

    @Override
    public int addAdmin(Admin admin) {
        Admin duplicate = adminDAO.getAdminInfo(admin.getAccount());
        if (duplicate == null || duplicate.getId() == null || ("".equals(duplicate.getId()))) {
            School school = schoolDAO.findSchool(admin.getSchoolCode());
            admin.setSchoolName(school.getSchoolName());
            admin.setSchoolLocation(school.getSchoolLocation());
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

    @Override
    public int systemAdminLogin(Admin admin) {
        admin.setLevel(AdminDirectory.AdminLevel.SYSTEM_ADMIN);
        return adminDAO.isExist(admin);
    }
}
