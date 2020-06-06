package cn.cqucc.library.model.admin;

import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/4/7 9:49
 * @Description 管理员实体类
 */
@Data
@ApiModel("管理员")
public class Admin implements Serializable {
    private static final long serialVersionUID = 6773008101902867903L;

    public Admin() {
    }

    public Admin(String id, String name, String account, String password,
                 Boolean isValid, Date createAt, String schoolName,
                 String schoolCode, String schoolLocation, int level) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.isValid = isValid;
        this.createAt = createAt;
        this.schoolName = schoolName;
        this.schoolCode = schoolCode;
        this.schoolLocation = schoolLocation;
        this.level = level;
    }

    @ApiModelProperty("管理员职工号")
    private String id;

    @ApiModelProperty("管理员姓名")
    private String name;

    @ApiModelProperty("管理员账户")
    private String account;

    @ApiModelProperty("管理员密码")
    private String password;

    @ApiModelProperty("账户是否有效可用")
    private Boolean isValid;

    @ApiModelProperty("创建时间")
    private Date createAt;

    @ApiModelProperty("最近变更时间")
    private Date updateAt;

    @ApiModelProperty("所属院校")
    private String schoolName;

    @ApiModelProperty("所属院校码")
    private String schoolCode;

    @ApiModelProperty("院校归属地名称")
    private String schoolLocation;

    @ApiModelProperty("管理员级别：1-系统管理员，2-院校超级管理员，3-院校普通管理员")
    private int level;

    public String getCreateAtStr() {
        return DateUtil.formatDate(createAt, "yy-MM-dd");
    }

    public String getUpdateAtStr() {
        return DateUtil.formatDate(updateAt, "yy-MM-dd");
    }
}
