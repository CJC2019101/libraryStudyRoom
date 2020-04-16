package cn.cqucc.library.controller.login;

import cn.cqucc.library.service.admin.api.ICKAdminAPI;
import cn.cqucc.library.service.student.api.ICKStudentApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/adminIsExist",method = RequestMethod.POST)
    @ApiOperation(value = "管理员登录判断")
    @ResponseBody
    public int adminIsExist(@RequestParam String account, @RequestParam String password) {
        return adminBO.isExist(account,password);
    }
}
