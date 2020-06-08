package cn.cqucc.library.model.room;

import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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

    @ApiModelProperty(value = "教室是否启用")
    private Boolean isValid;

    @ApiModelProperty(value = "院校标识码")
    private String schoolCode;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    public String getCreateAtStr() {
        return DateUtil.formatDate(createAt);
    }

    public String getUpdateAtStr() {
        return DateUtil.formatDate(updateAt);
    }

}
