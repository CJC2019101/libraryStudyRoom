package cn.cqucc.library.appController.chair;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.model.chair.req.ChairReq;
import cn.cqucc.library.model.chair.resp.ChairResp;
import cn.cqucc.library.service.chair.api.ICKChairAPI;
import cn.cqucc.library.status.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yaohengfeng
 * @version 1.0
 * @date 2020/6/5 17:50
 */
@RestController
@Api(tags = "小程序-座位")
@RequestMapping("/wx")
@CrossOrigin
public class WxChairController {
    @Autowired
    private ICKChairAPI chairApi;

    @PostMapping(value = "selectAllChair")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "roomId", value = "教室号", required = true),
            @ApiImplicitParam(paramType = "query", name = "floorNumber", value = "楼层号", required = true)
    }
    )
    @ApiOperation(value = "获取被占用的座位")
    @ResponseBody
    public BaseResponse selectAllChair(ChairResp chairResp) {
        List<ChairReq> occupyChairs = chairApi.selectAllChairs(chairResp);
        BaseResponse<List> response = new BaseResponse<>();
        response.setData(occupyChairs);
        response.setCode(200);
        return response;
    }
    @PostMapping(value = "selectChair")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "insert", name = "教室号", value = "roomId", required = true),
            @ApiImplicitParam(paramType = "insert", name = "楼层", value = "floorNumber", required = true),
            @ApiImplicitParam(paramType = "insert", name = "行", value = "rows", required = true),
            @ApiImplicitParam(paramType = "insert", name = "列", value = "cells", required = true),
            @ApiImplicitParam(paramType = "insert", name = "0-一天，1-上午，2-下午，3-晚上，4-永久", value = "status", required = true),
            @ApiImplicitParam(paramType = "insert", name = "账户", value = "account", required = true)
    })
    @ApiOperation(value = "选中座位")
    @ResponseBody
    public BaseResponse selectChair(Chair chair) {
        BaseResponse response = new BaseResponse();
        int status = chairApi.selectChair(chair);
        response.setCode(status);
        response.setCode(200);
        return response;
    }

    @PostMapping(value = "selectChairHistory")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "insert", name = "账户", value = "userId", required = true)
    })
    @ApiOperation(value = "选中座位")
    @ResponseBody
    public BaseResponse selectChairHistory(String  userId) {
        BaseResponse response = new BaseResponse();
        List<Chair> chairList=chairApi.selectChairHistory(userId);
        if (chairList==null||chairList.isEmpty()){
            response.setMsg("还没有选过座位");
            response.setCode(502);
        }else {
            response.setData(chairList);
            response.setCode(200);
        }
//        response.setCode(status);

        return response;
    }
}
