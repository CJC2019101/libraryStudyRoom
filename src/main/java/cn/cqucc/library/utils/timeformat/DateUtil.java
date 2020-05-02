package cn.cqucc.library.utils.timeformat;

import cn.cqucc.library.utils.annotation.description.Description;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JianfeiChen
 * @date 2020/5/2 15:48
 * @Description cn.cqucc.library.utils.timeformat
 */
@Description(description = "时间工具类")
public class DateUtil {
    /**
     * 标准时间格式
     */
    private static String NORM_DATE_PATTERN = "yyyy年MM月dd日 hh时mm分";

    /**
     * 格式化日期,默认为："yyyy年MM月dd日 hh时mm分"
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return formatDate(date, null);
    }

    /**
     * 格式化日期,默认为："yyyy年MM月dd日 hh时mm分"
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = NORM_DATE_PATTERN;
        }
        return new SimpleDateFormat(format).format(date);
    }

}
