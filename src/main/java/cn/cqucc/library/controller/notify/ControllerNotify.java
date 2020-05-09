package cn.cqucc.library.controller.notify;

import cn.cqucc.library.model.notify.Notify;
import cn.cqucc.library.service.notify.bo.CKNotifyBO;
import cn.cqucc.library.status.BaseResponse;
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

import javax.swing.text.StyledEditorKit;

/**
 * @author JianfeiChen
 * @date 2020/5/9 21:27
 * @Description cn.cqucc.library.controller.notify
 */
@Controller
public class ControllerNotify {

    @Autowired
    CKNotifyBO notifyBO;

    @RequestMapping(value = "/addNotify", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "insert", name = "title", value = "公告标题", required = true),
            @ApiImplicitParam(type = "insert", name = "content", value = "公告内容", required = true),
            @ApiImplicitParam(type = "insert", name = "account", value = "操作账户", required = true),
            @ApiImplicitParam(type = "insert", name = "isValid", value = "是否有效", required = true),
            @ApiImplicitParam(type = "insert", name = "status", value = "公告状态：0-过期，1-有效，2-草稿", required = true)
    })
    @ApiOperation(value = "管理员添加公告")
    @ResponseBody
    public BaseResponse addNotify(@RequestBody Notify notify) {
        BaseResponse response = new BaseResponse();
        notifyBO.addNotify(notify);
        response.setMsg("添加成功");
        response.setCode(200);
        return response;
    }

    @RequestMapping(value = "/hasDubiousNotify",method = RequestMethod.GET)
    @ApiImplicitParam(type = "query",name = "account",value = "管理员账户",required = true)
    @ApiOperation(value = "当前账户是否有草稿公告")
    @ResponseBody
    public BaseResponse hasDubiousNotify(@RequestParam String account){
        BaseResponse response = new BaseResponse();
        Notify notify = notifyBO.hasDubiousNotify(account);
        if (notify==null){
            response.setCode(406);
            response.setMsg("当前用户没有草稿公告存留");
        }else {
            response.setCode(200);
            response.setMsg("您有草稿存留是否需要重新加载，如果取消会丢失当前草稿");
            response.setData(notify);
        }
        return response;
    }

}
