package cn.cqucc.library.controller.floor;

import cn.cqucc.library.model.floor.Floor;
import cn.cqucc.library.service.floor.bo.CKFloorBO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/15 8:33
 * @Description 楼层
 */
@Api(tags = "楼层")
@Controller
public class ControllerFloor {

    @Autowired
    CKFloorBO floorBO;

    @RequestMapping(value = "/findRooms",method = RequestMethod.GET)
    @ResponseBody
    public List<Floor> findRooms(@RequestParam String floorNumber){
        return floorBO.findRooms(Integer.parseInt(floorNumber));
    }
}
