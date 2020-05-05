package cn.cqucc.library.service.admin.dao;

import cn.cqucc.library.model.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author JianfeiChen
 * @date 2020/4/7 9:55
 * @Description cn.cqucc.library.service.admin.dao
 */
@Mapper
public interface ICKAdminDAO {
    int isExist(@Param(value = "account")String account, @Param(value = "password")String password);

    Admin getAdminInfo(@Param(value = "account") String account);
}
