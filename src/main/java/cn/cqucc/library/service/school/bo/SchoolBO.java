package cn.cqucc.library.service.school.bo;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.school.req.ManualAddSchoolReq;
import cn.cqucc.library.model.school.resp.FindAllSchoolResp;
import cn.cqucc.library.service.admin.dao.ICKAdminDAO;
import cn.cqucc.library.service.school.api.ISchoolApi;
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
 * @date 2020/6/5 22:08
 * @Description cn.cqucc.library.service.school.bo
 */
@Service
public class SchoolBO implements ISchoolApi {

    @Autowired
    ISchoolDAO schoolDAO;
    @Autowired
    ICKAdminDAO adminDAO;

    @Override
    // TODO 添加事务回滚
    public int insertSchool(ManualAddSchoolReq schoolReq) {
        int isExist = schoolDAO.schoolIsExist(schoolReq.getSchoolCode());
        if (isExist == 1) {
            return 502;
        } else {
            schoolReq.setCreateAt(new Date());
            schoolDAO.insertSchool(schoolReq);
            Admin admin = new Admin(UUID.randomUUID().toString().replaceAll("-", ""),
                    schoolReq.getAdminName(), schoolReq.getAdminAccount(), schoolReq.getAdminPassword(), true,
                    new Date(), schoolReq.getSchoolName(), schoolReq.getSchoolCode(), schoolReq.getSchoolLocation(),
                    schoolReq.getAdminLevel());
            adminDAO.addAdmin(admin);
            return 200;
        }
    }

    @Override
    public PageInfo findAllSchool(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<FindAllSchoolResp> schools = schoolDAO.findAllSchool();
        return new PageInfo(schools);
    }

    @Override
    public void setSchoolIsValid(String schoolCode) {
        schoolDAO.setSchoolIsValid(schoolCode);
        Admin admin = new Admin();
        admin.setSchoolCode(schoolCode);
        adminDAO.setAdminIsValid(admin);
    }

    @Override
    public PageInfo searchSchools(String keyWord) {
        PageHelper.startPage(1, 10);
        List<FindAllSchoolResp> schoolResps = schoolDAO.searchSchools(keyWord);
        return new PageInfo(schoolResps);
    }

    @Override
    // TODO 添加事务回滚
    public void updateSchool(ManualAddSchoolReq school) {
        schoolDAO.updateSchool(school);
        adminDAO.updateAdmin(school.getAdminAccount(),school.getAdminName());
    }
}
