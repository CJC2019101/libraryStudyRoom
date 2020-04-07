package cn.cqucc.library.service.admin.bo;

import cn.cqucc.library.service.admin.api.ICKAdminAPI;
import cn.cqucc.library.service.admin.dao.ICKAdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return adminDAO.isExist(account,password);
    }
}
