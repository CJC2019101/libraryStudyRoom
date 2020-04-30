package cn.cqucc.library.model.student.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/30 10:33
 * @Description 学生信息类
 */
@Data
@ApiModel(value = "学生信息")
public class StudentInfoResp implements Serializable {

    private static final long serialVersionUID = 5332382941455177688L;

    @ApiModelProperty("用户ID")
    String userId;

    @ApiModelProperty("用户名称")
    String userName;

    @ApiModelProperty("年龄")
    int userAge;

    @ApiModelProperty("专业年级")
    String processionGrade;

    @ApiModelProperty("选座总次数")
    int totalCount;

    @ApiModelProperty("性别：1-男，0-女")
    int userSex;
}
