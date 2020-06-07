package cn.cqucc.library.model.school.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/6/6 11:56
 * @Description cn.cqucc.library.model.school.req
 */
@Data
@ApiModel("手动添加的院校信息实体类")
public class ManualAddSchoolReq implements Serializable {
    private static final long serialVersionUID = 2379278019223225913L;

    @ApiModelProperty("院校标识码")
    private String schoolCode;

    @ApiModelProperty("院校名称")
    private String schoolName;

    @ApiModelProperty("院校归属地")
    private String schoolLocation;

    @ApiModelProperty("院校超级管理员姓名")
    private String adminName;

    @ApiModelProperty("院校超级管理员账户")
    private String adminAccount;

    @ApiModelProperty("院校超级管理员密码")
    private String adminPassword;

    @ApiModelProperty("管理员级别：1-系统管理员，2-院校超级管理员，3-院校普通管理员")
    private int adminLevel;

    @ApiModelProperty("创建时间")
    private Date createAt;

    @ApiModelProperty("是否有效")
    private boolean isValid;
}
