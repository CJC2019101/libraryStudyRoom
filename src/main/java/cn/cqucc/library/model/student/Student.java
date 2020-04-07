package cn.cqucc.library.model.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:55
 * @Description 学生实体类
 */

@Data
@ApiModel("学生")
public class Student implements Serializable {
    private static final long serialVersionUID = 2537006568381805744L;

    @ApiModelProperty("学号")
    private String studentId;

    @ApiModelProperty("姓名")
    private String studentName;

    @ApiModelProperty("年龄")
    private Integer studentAge;

    @ApiModelProperty("身份证号码")
    private String studentIdCard;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("专业年级")
    private String processionGrade;
}
