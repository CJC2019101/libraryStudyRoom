package cn.cqucc.library.controller.notify;

import cn.cqucc.library.model.notify.Notify;
import cn.cqucc.library.model.notify.req.NotifyFindAllReq;
import cn.cqucc.library.service.notify.bo.CKNotifyBO;
import cn.cqucc.library.service.notify.dao.ICKNotifyDAO;
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
import org.springframework.web.servlet.DispatcherServlet;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/5/9 21:27
 * @Description cn.cqucc.library.controller.notify
 */
@Controller
public class ControllerNotify {

    @Autowired
    CKNotifyBO notifyBO;

    @Autowired
    ICKNotifyDAO notifyDAO;

    @RequestMapping(value = "/addNotify", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "insert", name = "id", value = "公告Id", required = true),
            @ApiImplicitParam(type = "insert", name = "title", value = "公告标题", required = true),
            @ApiImplicitParam(type = "insert", name = "content", value = "公告内容", required = true),
            @ApiImplicitParam(type = "insert", name = "account", value = "操作账户", required = true),
            @ApiImplicitParam(type = "insert", name = "isValid", value = "是否有效", required = true),
            @ApiImplicitParam(type = "insert", name = "lookedUserId", value = "查看的用户ID", required = true),
            @ApiImplicitParam(type = "insert", name = "status", value = "公告状态：0-草稿，1-发布", required = true)
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

    @RequestMapping(value = "/hasDubiousNotify", method = RequestMethod.GET)
    @ApiImplicitParam(type = "query", name = "account", value = "管理员账户", required = true)
    @ApiOperation(value = "当前账户是否有草稿公告")
    @ResponseBody
    public BaseResponse hasDubiousNotify(@RequestParam String account) {
        BaseResponse response = new BaseResponse();
        Notify notify = notifyBO.hasDubiousNotify(account);
        if (notify == null || notify.getId() == null || ("".equals(notify.getId()))) {
            response.setCode(406);
            response.setMsg("当前用户没有草稿公告存留");
        } else {
            response.setCode(200);
            response.setMsg("您有草稿存留是否需要重新加载，如果取消会丢失当前草稿");
            response.setData(notify);
        }
        return response;
    }

    @RequestMapping(value = "/updateNotifyStatus", method = RequestMethod.GET)
    @ApiImplicitParam(type = "query", name = "account", value = "当前管理员账户", required = true)
    @ApiOperation(value = "更新公告状态")
    @ResponseBody
    public BaseResponse updateNotifyStatus(@RequestParam String account) {
        notifyDAO.updateNotifyStatus(account);
        BaseResponse response = new BaseResponse();
        return response;
    }

    @RequestMapping(value = "/findAllNotify", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "account", value = "当前账户", required = true),
            @ApiImplicitParam(type = "query", name = "pageNumber", value = "当前查询页", required = true)
    })
    @ApiOperation(value = "查询所有发布公共")
    @ResponseBody
    public BaseResponse findAllNotify(@RequestBody NotifyFindAllReq account) {
        BaseResponse response = new BaseResponse();
        PageInfo pageInfo = notifyBO.findAllNotify(account);
        response.setData(pageInfo);
        response.setCode(200);
        if (pageInfo.getSize() == 0){
            response.setMsg("数据库没有数据显示");
        }else {
            response.setMsg("success");
        }
        return response;
    }

    @RequestMapping(value = "/findNotify", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "id", value = "公共ID", required = true)
    })
    @ApiOperation(value = "查询发布公共")
    @ResponseBody
    public BaseResponse findNotify(@RequestParam(value = "id") String id) {
        BaseResponse response = new BaseResponse();
        Notify notify = notifyBO.findNotify(id);
        response.setData(notify);
        response.setCode(200);
        response.setMsg("success");
        return response;
    }


    @RequestMapping(value = "/lookNotify", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "update", name = "id", value = "公共id", required = true),
            @ApiImplicitParam(type = "update", name = "lookedUserId", value = "查看的用户ID", required = true)
    })
    @ApiOperation(value = "查看公告")
    @ResponseBody
    public BaseResponse lookNotify(@RequestBody Notify notify) {
        BaseResponse response = new BaseResponse();
        notifyBO.lookNotify(notify);
        response.setCode(200);
        response.setMsg("success");
        return response;
    }

}
