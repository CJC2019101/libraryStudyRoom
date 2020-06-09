package cn.cqucc.library.appController.login;

import cn.cqucc.library.model.student.resp.WxUserResp;
import cn.cqucc.library.service.student.api.ICKStudentApi;
import cn.cqucc.library.status.BaseResponse;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaohengfeng
 * @version 1.0
 * @date 2020/6/8 19:18
 */
@RestController
@Api(tags = "小程序-用户登录")
@RequestMapping("wx")
public class WxLoginController {
    @Autowired
    private ICKStudentApi studentApi;

    @PostMapping(value = "wxLogin")
    @ApiImplicitParams({
            @ApiImplicitParam(type= "select", name = "code", value = "微信code", required = true),
            @ApiImplicitParam(type = "select", name = "sno", value = "账号", required = true),
            @ApiImplicitParam(type = "select", name = "pwd", value = "密码", required = true)
    } )
    @ApiOperation(value = "小程序登录")
    @ResponseBody
    public BaseResponse wxLogin(WxUserResp wxUser){
        return studentApi.loginUser(wxUser);
    }
}
