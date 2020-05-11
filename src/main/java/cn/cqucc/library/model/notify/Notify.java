package cn.cqucc.library.model.notify;

import cn.cqucc.library.utils.timeformat.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/5/9 21:41
 * @Description cn.cqucc.library.model.notify.req
 */
@ApiModel(value = "添加公告")
@Data
public class Notify implements Serializable, Comparable<Notify> {
    private static final long serialVersionUID = -1131706633544772087L;

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "操作账户")
    private String account;

    @ApiModelProperty(value = "主键ID")
    private String title;

    @ApiModelProperty(value = "主键ID")
    private String content;

    @ApiModelProperty(value = "是否有效")
    private Boolean isValid;

    @ApiModelProperty(value = "公告状态：0-过期，1-已发布，2-草稿")
    private Integer status;

    @ApiModelProperty(value = "主键ID")
    private Date createAt;

    @ApiModelProperty(value = "查阅的用户ID")
    private String[] lookedUserId;

    // 当前用户是否阅读该公共
    public Boolean isLooked() {
        return Arrays.asList(lookedUserId).contains(account);
    }

    public String getCreateAtStr() {
        return DateUtil.formatDate(createAt);
    }

    public String getShortTitle() {
        if (title.length() > 6) {
            return title.substring(0, 6) + ">>>";
        } else {
            return title;
        }
    }

    @Override
    public int compareTo(Notify that) {
        if (that.isLooked() && (!this.isLooked())) {
            return 1;
        } else if (this.isLooked() && (!that.isLooked())) {
            return -1;
        } else {
            return this.createAt.compareTo(that.createAt);
        }
    }
}
