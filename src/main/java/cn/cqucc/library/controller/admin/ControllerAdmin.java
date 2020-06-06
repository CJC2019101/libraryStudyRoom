package cn.cqucc.library.controller.admin;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.service.admin.bo.CKAdminBO;
import cn.cqucc.library.status.BaseResponse;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/5/6 14:50
 * @Description cn.cqucc.library.controller.admin
 */
@Controller
public class ControllerAdmin {

    @Autowired
    CKAdminBO adminBO;

    @RequestMapping(value = "/adminResetPassword", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "update", value = "name", name = "新名称", required = true),
            @ApiImplicitParam(type = "update", value = "password", name = "新密码", required = true),
            @ApiImplicitParam(type = "update", value = "account", name = "账号", required = true),
            @ApiImplicitParam(type = "update", value = "userType", name = "用户类型", required = true)
    })
    @ApiOperation(value = "管理员用户重置密码")
    @ResponseBody
    //TODO 后续添加事务的回滚功能。
    public BaseResponse resetPassword(@RequestBody CKLibraryUserReq user) {
        BaseResponse response = new BaseResponse();
        adminBO.resetPassword(user);
        response.setCode(200);
        response.setData(true);
        return response;
    }

    @RequestMapping(value = "/findAllAdmins", method = RequestMethod.GET)
    @ApiImplicitParam(type = "query", name = "pageNumber", value = "当前页", required = true)
    @ApiOperation(value = "查询所有管理员账户信息，除开超级管理员")
    @ResponseBody
    public BaseResponse findAllAdmins(@RequestParam Integer pageNumber) {
        BaseResponse response = new BaseResponse();
        PageInfo<List> pageInfo = adminBO.findAllAdmins(pageNumber);
        response.setCode(200);
        response.setMsg("success");
        response.setData(pageInfo);
        return response;
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "insert", name = "name", value = "管理员名称", required = true),
            @ApiImplicitParam(type = "insert", name = "account", value = "管理员密码：为空则为默认密码admin", required = true),
            @ApiImplicitParam(type = "insert", name = "password", value = "管理员密码", required = true),
            @ApiImplicitParam(type = "insert", name = "schoolName", value = "所属院校", required = true),
            @ApiImplicitParam(type = "insert", name = "schoolCode", value = "所属院校码", required = true),
            @ApiImplicitParam(type = "insert", name = "schoolLocation", value = "所属院校归属地", required = true)
    })
    @ApiOperation(value = "添加普通管理员")
    @ResponseBody
    public BaseResponse addAdmin(@RequestBody Admin admin) {
        BaseResponse response = new BaseResponse();
        int statusCode = adminBO.addAdmin(admin);
        if (statusCode == 200) {
            response.setMsg("添加成功");
        } else if (statusCode == 502) {
            response.setMsg("添加失败，存在相同的管理员账户或所属院校不存在");
        }
        response.setCode(statusCode);
        return response;
    }

    @RequestMapping(value = "/setAdminIsValid", method = RequestMethod.GET)
    @ApiImplicitParam(type = "update", name = "account", value = "管理员账户", required = true)
    @ApiOperation(value = "修改普通管理员是否可用")
    @ResponseBody
    // TODO 后续添加事务控制
    public BaseResponse setAdminIsValid(@RequestParam String account) {
        BaseResponse response = new BaseResponse();
        adminBO.setAdminIsValid(account);
        response.setCode(200);
        response.setMsg("修改成功");
        return response;
    }

}
