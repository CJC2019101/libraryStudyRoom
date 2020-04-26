package cn.cqucc.library.model.chair.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/24 13:32
 * @Description cn.cqucc.library.model.chair.resp
 */

@Data
@ApiModel(value = "学生选座信息")
public class CKStudentChairInfo implements Serializable {

    private static final long serialVersionUID = 7114450982687411017L;

    @ApiModelProperty(value = "教室号")
    private String roomId;

    @ApiModelProperty(value = "楼层号")
    private int floorNumber;

    @ApiModelProperty(value = "行号")
    private int crow;

    @ApiModelProperty(value = "列号")
    private int cell;

    @ApiModelProperty(value = "学生学号")
    private String userId;

    @ApiModelProperty(value = "学生姓名")
    private String userName;

    @ApiModelProperty(value = "学生专业年级")
    private String processionGrade;

    @ApiModelProperty(value = "座位状态")
    private int status;

}
