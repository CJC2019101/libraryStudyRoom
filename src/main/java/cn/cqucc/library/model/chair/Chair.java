package cn.cqucc.library.model.chair;

import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/4/21 16:20
 * @Description 座位实体类
 */
@ApiModel(value = "座位")
@Data
public class Chair implements Serializable {
    private static final long serialVersionUID = -3908479939340949556L;


    @ApiModelProperty(value = "主键ID")
    private String id;

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

    @ApiModelProperty(value = "座位选中状态：0-全天，1-上午，2-下午，3-晚上")
    private Integer status;

    @ApiModelProperty("状态：0-未签到 1-已签到 2-逾期 3-取消")
    private Integer signStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    public String getCreateAtStr() {
        return DateUtil.formatDate(createAt);
    }

    public String getUpdateAtStr(){
        return DateUtil.formatDate(updateAt);
    }

}
