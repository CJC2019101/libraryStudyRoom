package cn.cqucc.library.model.room.req;

import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/5/7 16:20
 * @Description cn.cqucc.library.model.room.req
 */

@Data
@ApiModel(value = "教室更新封装实体类")
public class RoomUpdateReq implements Serializable {
    private static final long serialVersionUID = -10736252585473755L;

    @ApiModelProperty(value = "新的教室编号")
    private String newRoomId;

    @ApiModelProperty(value = "旧的教室编号")
    private String oldRoomId;

    @ApiModelProperty(value = "楼层编号")
    private int floorNumber;

    @ApiModelProperty(value = "教室长度")
    private int roomLong;

    @ApiModelProperty(value = "教室宽度")
    private int roomWidth;

    @ApiModelProperty(value = "教室是否启用")
    private Boolean isValid;

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
