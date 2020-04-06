package cn.cqucc.library.controller.login;

import cn.cqucc.library.service.api.ICKStudentApi;
import cn.cqucc.library.service.bo.CKStudentBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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
public class Login {

    @Autowired
    private ICKStudentApi studentBO;

    @RequestMapping("/login")
    @ApiOperation(value = "访问登录主页")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/isExist",method = RequestMethod.POST)
    @ApiOperation(value = "登录判断")
    @ResponseBody
    public int isExist(@RequestParam String account,@RequestParam String password){
        return studentBO.isExist(account,password);
    }

    @RequestMapping("/register")
    @ApiOperation(value = "访问注册主页")
    public String userRegister() {
        return "register";
    }
}
