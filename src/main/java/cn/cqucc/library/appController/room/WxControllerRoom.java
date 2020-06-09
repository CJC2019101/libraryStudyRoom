package cn.cqucc.library.appController.room;

import cn.cqucc.library.service.room.bo.CKRoomBO;
import cn.cqucc.library.status.BaseResponse;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yaohengfeng
 * @version 1.0
 * @date 2020/6/5 15:09
 */
@Controller
@Api(tags = "小程序-房间")
@RequestMapping("wx")
public class WxControllerRoom {

    @Autowired
    private CKRoomBO roomBO;

    @GetMapping(value = "findValidRooms")
    @ApiImplicitParams({
            @ApiImplicitParam(type= "select", name = "pageNumber", value = "页数", required = true),
            @ApiImplicitParam(type = "select", name = "pageSize", value = "页面大小", required = true)
    } )
    @ApiOperation(value = "查找可用教室")
    @ResponseBody
    public BaseResponse findValidRooms(@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
        PageInfo allRooms = roomBO.findValidRooms(pageNumber,pageSize);
        BaseResponse response = new BaseResponse();
        if (allRooms.getSize() == 0) {
            response.setCode(502);
            response.setMsg("数据库没有数据显示");
        } else {
            response.setCode(200);
            response.setMsg("成功");
            response.setData(allRooms);
        }
        return response;
    }


}
