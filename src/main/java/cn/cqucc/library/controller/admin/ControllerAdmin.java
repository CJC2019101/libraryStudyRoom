package cn.cqucc.library.controller.admin;

import cn.cqucc.library.model.student.req.CKLibraryUserReq;
import cn.cqucc.library.service.admin.bo.CKAdminBO;
import cn.cqucc.library.status.BaseResponse;
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
 * @date 2020/5/6 14:50
 * @Description cn.cqucc.library.controller.admin
 */
@Controller
public class ControllerAdmin {

    @Autowired
    CKAdminBO adminBO;

    @RequestMapping(value = "/adminResetPassword", method = RequestMethod.POST)
    @ApiImplicitParams({
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
}
