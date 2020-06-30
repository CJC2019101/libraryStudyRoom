package cn.cqucc.library.controller.login;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.model.student.Student;
import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.service.admin.api.ICKAdminAPI;
import cn.cqucc.library.service.student.api.ICKStudentApi;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JianfeiChen
 * @date 2020/4/5 17:21
 * @Description cn.cqucc.library.login
 */
@Api(tags = "用户登录")
@Controller
public class ControllerLogin {

    @Autowired
    private ICKStudentApi studentBO;
    @Autowired
    private ICKAdminAPI adminBO;

    @RequestMapping("/login")
    @ApiOperation(value = "访问学生登录主页")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/isExist", method = RequestMethod.POST)
    @ApiOperation(value = "学生登录判断")
    @ResponseBody
    public int isExist(@RequestParam String account, @RequestParam String password) {
        return studentBO.isExist(account, password);
    }

    @RequestMapping("/register")
    @ApiOperation(value = "访问注册主页")
    public String userRegister() {
        return "register";
    }

    @RequestMapping(value = "/adminLogin")
    @ApiOperation(value = "访问管理员登录主页")
    public String adminLogin() {
        return "adminLogin";
    }

    @RequestMapping(value = "/adminIsExist", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "account", value = "用户账户", required = true),
            @ApiImplicitParam(paramType = "query", name = "password", value = "用户密码", required = true)
    })
    @ApiOperation(value = "管理员登录判断")
    @ResponseBody
    public int adminIsExist(@RequestBody Admin admin) {
        return adminBO.isExist(admin);
    }


    @RequestMapping(value = "/getUserInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "account", value = "账号", required = true),
            @ApiImplicitParam(type = "query", name = "password", value = "密码", required = true)
    })
    @ApiOperation(value = "获取用户信息，后续添加用户类型判断。")
    @ResponseBody
    public BaseResponse getUserInfo(@RequestParam String account, @RequestParam String password) {
        BaseResponse response = new BaseResponse();
        Student student = studentBO.getUserInfo(account, password);
        if (student.getStudentId() == null || student.getStudentId().equals("")) {
            response.setMsg("数据库信息不存在");
            response.setCode(502);
        } else {
            response.setData(student);
            response.setCode(200);
        }
        return response;
    }

    @RequestMapping(value = "/userResetPassword", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "update", value = "password", name = "新密码", required = true),
            @ApiImplicitParam(type = "update", value = "account", name = "账号", required = true),
            @ApiImplicitParam(type = "update", value = "userType", name = "用户类型", required = true)
    })
    @ApiOperation(value = "普通用户重置密码")
    @ResponseBody
    public BaseResponse resetPassword(@RequestBody CKLibraryUserReq user) {
        BaseResponse response = new BaseResponse();
        studentBO.resetPassword(user);
        response.setCode(200);
        response.setData(true);
        return response;
    }

    @RequestMapping(value = "/getAdminInfo",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query",name = "account",value = "账号",required = true),
            @ApiImplicitParam(type = "query",name = "password",value = "密码",required = true)
    })
    @ApiOperation(value = "获取管理员用户信息")
    @ResponseBody
    public BaseResponse getAdminInfo(@RequestParam String account){
        BaseResponse response = new BaseResponse();
        Admin admin = adminBO.getAdminInfo(account);
        if (admin==null){
            response.setCode(502);
            response.setMsg("查询管理员用户信息失败");
        }else {
            response.setCode(200);
            response.setData(admin);
        }
        return response;
    }

    @RequestMapping(value = "/systemAdminLogin",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query",name = "account",value = "系统管理员账户",required = true),
            @ApiImplicitParam(type = "query",name = "password",value = "密码",required = true)
    })
    @ApiOperation("系统管理员登录判断")
    @ResponseBody
    public int systemAdminLogin(@RequestBody Admin admin){
        return adminBO.systemAdminLogin(admin);
    }

}
