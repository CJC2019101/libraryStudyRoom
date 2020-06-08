package cn.cqucc.library.model.notify.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/5/10 16:58
 * @Description cn.cqucc.library.model.notify.req
 */
@ApiModel("查询所属院校所有发布公告")
@Data
public class NotifyFindAllReq implements Serializable {
    private static final long serialVersionUID = -2784598400874963893L;

    @ApiModelProperty(value = "当前账户")
    private String account;

    @ApiModelProperty(value = "当前的查询页")
    private Integer pageNumber;

    @ApiModelProperty(value = "院校标识码")
    private String schoolCode;
}
