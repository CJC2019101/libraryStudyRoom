package cn.cqucc.library.controller.school;

import cn.cqucc.library.model.school.req.ManualAddSchoolReq;
import cn.cqucc.library.service.school.bo.SchoolBO;
import cn.cqucc.library.status.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JianfeiChen
 * @date 2020/5/31 10:20
 * @Description cn.cqucc.library.controller.school
 */
@Api(tags = "系统加盟院校")
@Controller
public class ControllerSchool {

    @Autowired
    SchoolBO schoolBO;

    @RequestMapping(value = "/manualAddSchool", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "insert", value = "schoolName", name = "院校名称", required = true),
            @ApiImplicitParam(type = "insert", value = "schoolCode", name = "院校标识码", required = true),
            @ApiImplicitParam(type = "insert", value = "schoolLocation", name = "院校归属地", required = true),
            @ApiImplicitParam(type = "insert", value = "adminName", name = "院校管理员名称", required = true),
            @ApiImplicitParam(type = "insert", value = "adminAccount", name = "院校管理员账户", required = true),
            @ApiImplicitParam(type = "insert", value = "adminPassword", name = "院校管理员密码", required = true),
            @ApiImplicitParam(type = "insert", value = "adminLevel", name = "院校管理员等级：1-系统管理员，2-院校超级管理员，3-院校普通管理员", required = true),
            @ApiImplicitParam(type = "insert", value = "isValid", name = "是否有效", required = true)
    })
    @ApiOperation("手动添加院校信息")
    @ResponseBody
    public BaseResponse manualAddSchool(@RequestBody ManualAddSchoolReq schoolReq) {
        BaseResponse response = new BaseResponse();
        int statusCode = schoolBO.insertSchool(schoolReq);
        response.setCode(statusCode);
        if (statusCode == 200){
            response.setMsg("添加成功");
        }else if (statusCode == 502){
            response.setMsg("添加失败，院校标识码重复");
        }
        return response;
    }
}
