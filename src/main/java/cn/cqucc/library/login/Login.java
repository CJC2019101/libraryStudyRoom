package cn.cqucc.library.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JianfeiChen
 * @date 2020/4/5 17:21
 * @Description cn.cqucc.library.login
 */
@Controller
public class Login {
    @RequestMapping("/login")
    public String userLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String userRegister(){
        return "register";
    }
}
