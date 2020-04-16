package cn.cqucc.library.model.floor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/15 18:03
 * @Description 楼层
 */
@Data
@ApiModel(value = "楼层实体类")
public class Floor implements Serializable {
    private static final long serialVersionUID = 7087957476562052534L;

    @ApiModelProperty(value = "楼层号")
    int floorNumber;

    @ApiModelProperty(value = "房间号")
    String[] roomNumber;
}
