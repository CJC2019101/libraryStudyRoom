package cn.cqucc.library.model.room;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/16 18:47
 * @Description 教室实体类
 */
@ApiModel(value = "教室实体类")
@Data
public class Room implements Serializable {
    private static final long serialVersionUID = -6097602359034132286L;
    @ApiModelProperty(value = "教室编号")
    private String id;

    @ApiModelProperty(value = "楼层编号")
    private int floorNumber;

    @ApiModelProperty(value = "教室长度")
    private int roomLong;

    @ApiModelProperty(value = "教室宽度")
    private int roomWidth;

}
