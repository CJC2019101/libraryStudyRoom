package cn.cqucc.library.service.room.dao;

import cn.cqucc.library.model.room.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/16 19:03
 * @Description cn.cqucc.library.service.room.dao
 */
@Mapper
public interface ICKRoomDAO {
    List<Room> findAll();

    Room findRoom(String roomId);

    List<Room> findValidRooms();
}
