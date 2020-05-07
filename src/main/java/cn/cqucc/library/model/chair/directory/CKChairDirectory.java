package cn.cqucc.library.model.chair.directory;

import cn.cqucc.library.utils.annotation.description.Description;

/**
 * @author JianfeiChen
 * @date 2020/4/26 13:59
 * @Description 座位数据字典实体类
 */
public class CKChairDirectory {

    @Description(description = "座位状态")
    public static class ChairStatus {

        @Description(description = "一整天")
        public static int allDay = 0;

        @Description(description = "上午")
        public static int morning = 1;

        @Description(description = "下午")
        public static int afternoon = 2;

        @Description(description = "晚上")
        public static int night = 3;

        @Description(description = "永远")
        public static int forever = 4;

    }
}
