package cn.cqucc.library.service.school.dao;

import cn.cqucc.library.model.school.School;
import cn.cqucc.library.model.school.req.ManualAddSchoolReq;
import cn.cqucc.library.model.school.resp.FindAllSchoolResp;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/6/5 22:07
 * @Description cn.cqucc.library.service.school.dao
 */
@Mapper
public interface ISchoolDAO {
    void addSchools(List<School> schools);

    void insertSchool(ManualAddSchoolReq schoolReq);

    int findSchool(String schoolCode);

    List<FindAllSchoolResp> findAllSchool();

    void setSchoolIsValid(String schoolCode);

    List<FindAllSchoolResp> searchSchools(String keyWord);

    void updateSchool(ManualAddSchoolReq school);
}
