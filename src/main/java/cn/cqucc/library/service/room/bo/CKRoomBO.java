package cn.cqucc.library.service.room.bo;

import cn.cqucc.library.model.room.Room;
import cn.cqucc.library.service.room.api.ICKRoomApi;
import cn.cqucc.library.service.room.dao.ICKRoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/16 18:56
 * @Description cn.cqucc.library.service.room.bo
 */
@Service
public class CKRoomBO implements ICKRoomApi {

    @Autowired
    ICKRoomDAO roomDAO;

    @Override
    public List<Room> findAll() {
        return roomDAO.findAll();
    }

    @Override
    public Room findRoom(String roomId) {
        return roomDAO.findRoom(roomId);
    }

    @Override
    public List<Room> findValidRooms() {
        return roomDAO.findValidRooms();
    }
}
