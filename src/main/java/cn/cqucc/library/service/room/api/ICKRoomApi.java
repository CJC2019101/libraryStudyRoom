package cn.cqucc.library.service.room.api;

import cn.cqucc.library.model.room.Room;
import cn.cqucc.library.model.room.req.RoomUpdateReq;
import cn.cqucc.library.model.room.req.wxRoomReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/16 18:59
 * @Description cn.cqucc.library.service.room.api
 */
public interface ICKRoomApi {
    PageInfo<List> findAll(Integer pageNumber, String schoolCode);

    Room findRoom(String roomId);

    PageInfo findValidRooms(Integer pageNumber);

    PageInfo findValidRoomsBySchoolCode(wxRoomReq wxRoomReq);

    int setRoomIsValid(Room room);

    int modifyRoomSize(RoomUpdateReq room);

    int createRoom(Room room);
}
