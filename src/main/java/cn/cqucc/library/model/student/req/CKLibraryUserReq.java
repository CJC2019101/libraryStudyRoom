package cn.cqucc.library.model.student.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/4/26 10:57
 * @Description cn.cqucc.library.model.student.req
 */
@Data
@ApiModel(description = "城科图书馆用户")
public class CKLibraryUserReq implements Serializable {

    private static final long serialVersionUID = 3207624320911396425L;

    @ApiModelProperty(value = "用户账号")
    String account;

    @ApiModelProperty(value = "用户密码")
    String password;

    @ApiModelProperty(value = "用户类型：0-学生、图书馆管理员, 1-学生，2-图书馆管理员")
    int userType;

}
