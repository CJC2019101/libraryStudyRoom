package cn.cqucc.library.service.school.api;

import cn.cqucc.library.model.school.req.ManualAddSchoolReq;

/**
 * @author JianfeiChen
 * @date 2020/6/5 22:08
 * @Description cn.cqucc.library.service.school.api
 */
public interface ISchoolApi {
    int insertSchool(ManualAddSchoolReq schoolReq);
}
