package cn.cqucc.library.controller.es;

import cn.cqucc.library.es.bo.SearchBO;
import cn.cqucc.library.status.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JianfeiChen
 * @date 2020/7/4 21:26
 * @Description cn.cqucc.library.controller.es
 */
@Controller
public class ControllerES {

    @Autowired
    SearchBO searchBO;

    @RequestMapping(value = "/transferSQLDataToES",method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse transferSQLDataToES(){
        searchBO.transferSQLDataToES();
        return null;
    }

}
