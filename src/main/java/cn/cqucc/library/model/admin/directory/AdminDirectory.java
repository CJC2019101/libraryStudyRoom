package cn.cqucc.library.model.admin.directory;

import cn.cqucc.library.utils.annotation.description.Description;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author JianfeiChen
 * @date 2020/5/31 15:58
 * @Description cn.cqucc.library.model.admin.directory
 */
@Description(description = "管理员数据字典")
public class AdminDirectory {

    public static class AdminLevel{

        @Description(description = "系统管理员")
        public static int SYSTEM_ADMIN = 1;

        @Description(description = "院校超级管理员")
        public static int SCHOOL_SUPER_ADMIN = 2;

        @Description(description = "院校普通管理员")
        public static int SCHOOL_NORMAL_ADMIN = 3;

    }
}
