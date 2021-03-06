package cn.cqucc.library.service.school.api;

import cn.cqucc.library.model.school.School;
import cn.cqucc.library.model.school.req.ManualAddSchoolReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/6/5 22:08
 * @Description cn.cqucc.library.service.school.api
 */
public interface ISchoolApi {
    int insertSchool(ManualAddSchoolReq schoolReq);

    PageInfo findAllSchool(Integer pageNum);

    void setSchoolIsValid(String schoolCode);

    PageInfo searchSchools(String keyWord);

    void updateSchool(ManualAddSchoolReq school);
}
