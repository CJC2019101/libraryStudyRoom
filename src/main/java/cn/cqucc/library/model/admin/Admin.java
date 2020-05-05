package cn.cqucc.library.model.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/7 9:49
 * @Description 管理员实体类
 */
@Data
@ApiModel("管理员实体类")
public class Admin implements Serializable {
    private static final long serialVersionUID = 6773008101902867903L;

    @ApiModelProperty("管理员职工号")
    private String id;

    @ApiModelProperty("管理员姓名")
    private String name;

    @ApiModelProperty("管理员账户")
    private String account;

    @ApiModelProperty("管理员密码")
    private String password;
}
