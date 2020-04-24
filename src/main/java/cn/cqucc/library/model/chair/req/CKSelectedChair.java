package cn.cqucc.library.model.chair.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/23 17:00
 * @Description cn.cqucc.library.model.chair.req
 */
@Data
@ApiModel("用户选中的座位")
public class CKSelectedChair implements Serializable {
    private static final long serialVersionUID = 3182840920184526742L;

    @ApiModelProperty(value = "教室ID")
    String roomId;

    @ApiModelProperty(value = "楼层")
    Integer floorNumber;

    @ApiModelProperty(value = "用户账户")
    String account;

    @ApiModelProperty(value = "行")
    List<Integer> rows;

    @ApiModelProperty(value = "列")
    List<Integer> cells;
}
