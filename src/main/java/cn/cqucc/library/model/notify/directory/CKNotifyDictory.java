package cn.cqucc.library.model.notify.directory;

import cn.cqucc.library.utils.annotation.description.Description;

/**
 * @author JianfeiChen
 * @date 2020/5/9 21:09
 * @Description 公共数据字典
 */
public class CKNotifyDictory {

    @Description(description = "公共状态")
    public static class Status {

        @Description(description = "过期")
        public static int useless = 0;

        @Description(description = "有效")
        public static int valid = 1;

        @Description(description = "不确定的")
        public static int dubious = 2;
    }
}
