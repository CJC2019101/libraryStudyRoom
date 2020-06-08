package cn.cqucc.library.model.student;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/6 10:55
 * @Description 学生-教职工实体类
 */

@Data
@ApiModel("学生-教职工")
public class Student implements Serializable {
    private static final long serialVersionUID = 2537006568381805744L;

    public Student() {
    }

    public Student(String studentId, String studentName, Integer studentAge,
                   String studentIdCard, String password, String processionGrade,
                   int sex, int userType, String schoolCode) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentIdCard = studentIdCard;
        this.password = password;
        this.processionGrade = processionGrade;
        this.sex = sex;
        this.userType = userType;
        this.schoolCode = schoolCode;
    }

    @ApiModelProperty("学号-职工号")
    private String studentId;

    @ApiModelProperty("姓名")
    private String studentName;

    @ApiModelProperty("年龄")
    private Integer studentAge;

    @ApiModelProperty("身份证号码")
    private String studentIdCard;

    @ApiModelProperty("登录密码：默认为身份证后六位")
    private String password;

    @ApiModelProperty("专业年级-教职工部门")
    private String processionGrade;

    @ApiModelProperty("性别：1-男，0-女")
    private int sex;

    @ApiModelProperty("用户类型：0-学生，1-教职工")
    private int userType;

    @ApiModelProperty("院校标识码")
    private String schoolCode;
}
