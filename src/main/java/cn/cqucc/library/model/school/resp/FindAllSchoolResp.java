package cn.cqucc.library.model.school.resp;

import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/6/7 11:54
 * @Description cn.cqucc.library.model.school.resp
 */
@Data
@ApiModel("查询所有院校信息响应的实体类")
public class FindAllSchoolResp implements Serializable {

    private static final long serialVersionUID = 2549484896886433838L;

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

    @ApiModelProperty("院校加盟时间")
    private Date createAt;

    @ApiModelProperty("院校更新时间")
    private Date updateAt;

    @ApiModelProperty("院校是否有效")
    private boolean isValid;

    public String getCreateStr() {
        return DateUtil.formatDate(this.createAt, "yyyy年M月d日");
    }

    public String getUpdateStr() {
        return DateUtil.formatDate(this.updateAt, "yyyy年M月d日");
    }
}
