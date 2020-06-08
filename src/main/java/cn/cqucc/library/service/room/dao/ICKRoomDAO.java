package cn.cqucc.library.service.room.dao;

import cn.cqucc.library.model.room.Room;
import cn.cqucc.library.model.room.req.RoomUpdateReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/16 19:03
 * @Description cn.cqucc.library.service.room.dao
 */
@Mapper
public interface ICKRoomDAO {
    List<Room> findAll(String schoolCode);

    Room findRoom(String roomId);

    List<Room> findValidRooms();

    void setRoomIsValid(Room room);

    void modifyRoomSize(RoomUpdateReq room);

    void createRoom(Room room);
}
