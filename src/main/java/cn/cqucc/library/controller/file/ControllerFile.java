package cn.cqucc.library.controller.file;

import cn.cqucc.library.service.file.bo.FileBO;
import cn.cqucc.library.status.BaseResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author JianfeiChen
 * @date 2020/6/5 10:18
 * @Description cn.cqucc.library.controller
 */
@Controller
public class ControllerFile {

    @Autowired
    FileBO fileBO;

    @RequestMapping(value = "/importFile", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(type = "insert", value = "file", name = "文件", required = true),
            @ApiImplicitParam(type = "insert", value = "filePath", name = "文件路径", required = true)
    })
    @ApiOperation("文件导入院校信息")
    @ResponseBody
    public BaseResponse importFile(@RequestParam("file") MultipartFile file, @RequestParam("filePath") String filePath) {
        BaseResponse response = new BaseResponse();
        String msg = fileBO.importFile(file, filePath);
        response.setMsg(msg);
        System.out.println(msg);
        return response;
    }

}
