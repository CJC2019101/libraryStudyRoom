package cn.cqucc.library.controller.chair;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.service.chair.bo.CKChairBO;
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

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/21 16:20
 * @Description
 */
@Controller
public class ControllerChair {

    @Autowired
    CKChairBO chairBO;

    @RequestMapping(value = "/occupyChairs", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "roomId", value = "教室号", required = true),
            @ApiImplicitParam(paramType = "query", name = "floorNumber", value = "楼层号", required = true)
    }
    )
    @ApiOperation(value = "获取被占用的座位")
    @ResponseBody
    public BaseResponse occupyChairs(@RequestBody Chair chair) {
        List<Chair> occupyChairs = chairBO.occupyChairs(chair);
        BaseResponse<List> response = new BaseResponse<>();
        response.setData(occupyChairs);
        response.setCode(200);
        return response;
    }


    @RequestMapping(value = "/selectChair", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "insert", name = "教室号", value = "roomId", required = true),
            @ApiImplicitParam(paramType = "insert", name = "行", value = "rows", required = true),
            @ApiImplicitParam(paramType = "insert", name = "列", value = "cells", required = true),
            @ApiImplicitParam(paramType = "insert", name = "账户", value = "account", required = true)
    })
    @ApiOperation(value = "选中座位")
    @ResponseBody
    public BaseResponse selectChair(@RequestBody List<Chair> chairs) {
        BaseResponse response = new BaseResponse();
        int status = chairBO.selectChair(chairs);
        response.setCode(status);
        if (status == 502) {
            response.setMsg("每个人最多选中四个座位，您选择的过多了");
            return response;
        }
        response.setCode(200);
        return response;
    }

    @RequestMapping(value = "/cancelChair", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "update", name = "roomId", value = "教室号", required = true),
            @ApiImplicitParam(paramType = "update", name = "floorNumber", value = "楼层号", required = true),
            @ApiImplicitParam(paramType = "update", name = "cell", value = "列", required = true),
            @ApiImplicitParam(paramType = "update", name = "crow", value = "行", required = true),
            @ApiImplicitParam(paramType = "update", name = "account", value = "账户", required = true)
    })
    @ApiOperation(value = "取消选中座位")
    @ResponseBody
    // TODO 后续添加事务的回滚
    public BaseResponse cancelChairs(@RequestBody List<Chair> chair) {
        BaseResponse response = new BaseResponse();
        chairBO.cancelChairs(chair);
        response.setCode(200);
        return response;
    }
}
