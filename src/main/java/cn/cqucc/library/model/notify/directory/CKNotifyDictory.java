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

        @Description(description = "草稿")
        public static int useless = 0;

        @Description(description = "发布")
        public static int valid = 1;

    }
}
