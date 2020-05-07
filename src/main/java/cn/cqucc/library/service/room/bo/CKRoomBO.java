package cn.cqucc.library.service.room.bo;

import cn.cqucc.library.model.room.Room;
import cn.cqucc.library.model.room.req.RoomUpdateReq;
import cn.cqucc.library.service.chair.bo.CKChairBO;
import cn.cqucc.library.service.chair.dao.ICKChairDAO;
import cn.cqucc.library.service.room.api.ICKRoomApi;
import cn.cqucc.library.service.room.dao.ICKRoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    ICKChairDAO chairDAO;

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

    @Override
    public int setRoomIsValid(Room room) {
        Integer count = chairDAO.getUnvalidChairCount(room);
        if (count > 0) {
            return 406;
        } else {
            room.setUpdateAt(new Date());
            roomDAO.setRoomIsValid(room);
            return 200;
        }

    }

    @Override
    public int modifyRoomSize(RoomUpdateReq room) {
        Room duplicate = roomDAO.findRoom(room.getNewRoomId());
        if (duplicate == null || duplicate.getId() == null || "".equals(duplicate.getId())) {
            room.setUpdateAt(new Date());
            roomDAO.modifyRoomSize(room);
            return 200;
        } else {
            return 406;
        }
    }

}
