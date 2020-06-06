package cn.cqucc.library.model.sign;

import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

/**
 * @author yaohengfeng
 * @version 1.0
 * @date 2020/6/6 16:38
 */
@Data
@ApiModel("签到")
public class Sign {

    private String signId;
    private String userId;
    private String roomId;
    private Integer floorNumber;
    @ApiModelProperty("状态：0-未签到 1-已签到 2-已释放")
    private int signStatus;
    private Date createAt;
    private Date updateAt;
    public String getCreateAtStr() {
        return DateUtil.formatDate(createAt);
    }

    public String getUpdateAtStr() {
        return DateUtil.formatDate(updateAt);
    }
}
