package cn.cqucc.library.model.school;

import cn.cqucc.library.model.admin.Admin;
import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/5/31 10:21
 * @Description cn.cqucc.library.model.school
 */
@Data
@ApiModel("院校")
public class School implements Serializable {

    private static final long serialVersionUID = 7124658204083156569L;

    public School() {
    }

    public School(String schoolCode, String schoolName, String schoolLocation,
                  String adminAccount, boolean isValid, Date createAt) {
        this.schoolCode = schoolCode;
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
        this.adminAccount = adminAccount;
        this.isValid = isValid;
        this.createAt = createAt;
    }

    @ApiModelProperty("院校标识码")
    private String schoolCode;

    @ApiModelProperty("院校名称")
    private String schoolName;

    @ApiModelProperty("院校归属地")
    private String schoolLocation;

    @ApiModelProperty("院校超级管理员账户")
    private String adminAccount;

    @ApiModelProperty("院校加盟时间")
    private Date createAt;

    @ApiModelProperty("院校更新时间")
    private Date updateAt;

    @ApiModelProperty("是否有效")
    private boolean isValid;

    public String getCreateStr() {
        return DateUtil.formatDate(createAt);
    }

    public String getUpdateStr() {
        return DateUtil.formatDate(updateAt);
    }

}
