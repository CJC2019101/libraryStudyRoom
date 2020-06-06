package cn.cqucc.library.model.file.directory;

import cn.cqucc.library.utils.annotation.description.Description;

import java.io.Serializable;

/**
 * @author JianfeiChen
 * @date 2020/6/5 13:31
 * @Description cn.cqucc.library.model.file.directory
 */
public class FileDirectory implements Serializable {
    private static final long serialVersionUID = 2795436689788610346L;

    public static class CellName {

        @Description(description = "账户或密码列")
        public static int PASSWORD_ACCOUNT = 1;

        @Description(description = "院校标识码")
        public static int SCHOOL_CODE = 2;

        @Description(description = "院校名称")
        public static int SCHOOL_NAME = 3;
    }
}
