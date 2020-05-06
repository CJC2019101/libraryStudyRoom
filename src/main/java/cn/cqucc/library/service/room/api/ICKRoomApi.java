package cn.cqucc.library.service.room.api;

import cn.cqucc.library.model.room.Room;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/16 18:59
 * @Description cn.cqucc.library.service.room.api
 */
public interface ICKRoomApi {
    List<Room> findAll();

    Room findRoom(String roomId);

    List<Room> findValidRooms();

    int setRoomIsValid(Room room);
}
