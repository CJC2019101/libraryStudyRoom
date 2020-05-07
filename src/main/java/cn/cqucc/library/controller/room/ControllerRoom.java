package cn.cqucc.library.controller.room;

import cn.cqucc.library.model.room.Room;
import cn.cqucc.library.model.room.req.RoomUpdateReq;
import cn.cqucc.library.service.room.bo.CKRoomBO;
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

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/16 18:57
 * @Description cn.cqucc.library.controller.room
 */
@Controller
public class ControllerRoom {

    @Autowired
    CKRoomBO roomBO;


    @RequestMapping(value = "/morning")
    @ApiOperation(value = "座位状态：上午")
    public String morning() {
        return "morning";
    }

    @RequestMapping(value = "/afternoon")
    @ApiOperation(value = "座位状态：下午")
    public String afternoon() {
        return "afternoon";
    }

    @RequestMapping(value = "/night")
    @ApiOperation(value = "座位状态：晚上")
    public String night() {
        return "night";
    }

    @RequestMapping(value = "/allDay")
    @ApiOperation(value = "座位状态：整天")
    public String allDay() {
        return "allDay";
    }

    @RequestMapping(value = "/cancel")
    @ApiOperation(value = "取消选座")
    public String cancel() {
        return "cancel";
    }


    @RequestMapping(value = "/findAllRooms")
    @ResponseBody
    public BaseResponse findAll() {
        List<Room> allRooms = roomBO.findAll();
        BaseResponse<List> response = new BaseResponse<List>();
        if (allRooms.size() == 0) {
            response.setCode(502);
            response.setMsg("数据库没有数据显示");
        } else {
            response.setCode(200);
            response.setMsg("成功");
            response.setData(allRooms);
        }

        return response;
    }

    @RequestMapping(value = "/findValidRooms")
    @ApiOperation(value = "查找可用教室")
    @ResponseBody
    public BaseResponse findValidRooms() {
        List<Room> allRooms = roomBO.findValidRooms();
        BaseResponse response = new BaseResponse();
        if (allRooms.size() == 0) {
            response.setCode(502);
            response.setMsg("数据库没有数据显示");
        } else {
            response.setCode(200);
            response.setMsg("成功");
            response.setData(allRooms);
        }
        return response;
    }


    @RequestMapping(value = "/findRoom", method = RequestMethod.GET)
    @ApiImplicitParam(paramType = "query", name = "roomId", value = "教室号", required = true)
    @ResponseBody
    public BaseResponse findRoom(@RequestParam(value = "roomId") String roomId) {
        Room room = roomBO.findRoom(roomId);
        BaseResponse<Room> response = new BaseResponse<Room>();
        if (room == null) {
            response.setCode(502);
            response.setMsg("数据库没有数据显示");
        } else {
            response.setCode(200);
            response.setMsg("成功");
            response.setData(room);
        }
        return response;
    }


    @RequestMapping(value = "/setRoomIsValid", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "update", name = "roomId", value = "教室ID", required = true),
            @ApiImplicitParam(type = "update", name = "floorNumber", value = "楼层号", required = true)
    })
    @ApiOperation(value = "管理员修改教室启用状态")
    @ResponseBody
    // TODO 后续添加事务回滚
    public BaseResponse setRoomIsValid(@RequestBody Room room) {
        BaseResponse response = new BaseResponse();
        int statusCode = roomBO.setRoomIsValid(room);
        response.setCode(statusCode);
        if (statusCode == 200) {
            response.setMsg("教室状态变更");
        } else {
            response.setMsg("教室座位有人选中无法变更状态。");
        }
        return response;
    }

    @RequestMapping(value = "/modifyRoomSize", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "update", name = "oldRoomId", value = "旧的教室号", required = true),
            @ApiImplicitParam(type = "update", name = "newRoomId", value = "新的教室号", required = true),
            @ApiImplicitParam(type = "update", name = "floorNumber", value = "楼层号", required = true),
            @ApiImplicitParam(type = "update", name = "roomWidth", value = "教室宽度", required = true),
            @ApiImplicitParam(type = "update", name = "roomLong", value = "教室长度", required = true)
    })
    @ApiOperation(value = "修改教室大小")
    @ResponseBody
    public BaseResponse modifyRoomSize(@RequestBody RoomUpdateReq room) {
        BaseResponse response = new BaseResponse();
        int statusCode = roomBO.modifyRoomSize(room);
        response.setCode(statusCode);
        if (statusCode == 200) {
            response.setMsg("修改成功");
        } else {
            response.setMsg("教室编号重复，请重新操作");
        }
        return response;
    }

}
