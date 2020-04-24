package cn.cqucc.library.model.chair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/21 16:20
 * @Description 座位实体类
 */
@ApiModel(value = "座位")
@Data
public class Chair implements Serializable {
    private static final long serialVersionUID = -3908479939340949556L;

    @ApiModelProperty(value = "教室号")
    private String roomId;

    @ApiModelProperty(value = "楼层号")
    private int floorNumber;

    @ApiModelProperty(value = "行号")
    private int crow;

    @ApiModelProperty(value = "列号")
    private int cell;

    @ApiModelProperty(value = "是否被占用")
    private Boolean isOccupy;

    @ApiModelProperty(value = "占用座位的用户ID")
    private String userId;

    @ApiModelProperty(value = "用户类型，0：学生、1：老师")
    private int userType;

    @ApiModelProperty(value = "是否是有效数据")
    private Boolean isValid;

}
