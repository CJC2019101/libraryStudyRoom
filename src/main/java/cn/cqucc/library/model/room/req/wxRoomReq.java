package cn.cqucc.library.model.room.req;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yaohengfeng
 * @version 1.0
 * @date 2020/6/9 15:14
 */
@Data
public class wxRoomReq {
    Integer pageNumber;
    Integer pageSize;
    String schoolCode;
}
