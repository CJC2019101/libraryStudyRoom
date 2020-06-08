package cn.cqucc.library.model.chair.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yaohengfeng
 * @version 1.0
 * @date 2020/6/6 1:49
 */
@Data
public class ChairReq {
    @ApiModelProperty(value = "行号")
    private int crow;

    @ApiModelProperty(value = "列号")
    private int cell;
}

