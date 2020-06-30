package cn.cqucc.library.service.room.bo;

import cn.cqucc.library.model.room.Room;
import cn.cqucc.library.model.room.req.RoomUpdateReq;
import cn.cqucc.library.service.chair.dao.ICKChairDAO;
import cn.cqucc.library.service.room.api.ICKRoomApi;
import cn.cqucc.library.service.room.dao.ICKRoomDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/16 18:56
 * @Description cn.cqucc.library.service.room.bo
 */
@Transactional
@Service
public class CKRoomBO implements ICKRoomApi {

    @Autowired
    ICKRoomDAO roomDAO;
    @Autowired
    ICKChairDAO chairDAO;

    @Override
    public PageInfo<List> findAll(Integer pageNumber, String schoolCode) {
        PageHelper.startPage(pageNumber, 9);
        List<Room> allRooms = roomDAO.findAll(schoolCode);
        return new PageInfo(allRooms);
    }

    @Override
    public Room findRoom(String roomId) {
        return roomDAO.findRoom(roomId);
    }

    @Override
    public PageInfo findValidRooms(Integer pageNumber) {
        PageHelper.startPage(pageNumber,8);
        List<Room> rooms = roomDAO.findValidRooms();
        return new PageInfo(rooms);
    }

    @Override
    public PageInfo findValidRooms(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Room> rooms = roomDAO.findValidRooms();
        return new PageInfo(rooms);
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
        Room duplicate = null;
        if (!room.getNewRoomId().equals(room.getOldRoomId())) {
            duplicate = roomDAO.findRoom(room.getNewRoomId());
        }
        if (duplicate == null || duplicate.getId() == null || "".equals(duplicate.getId())) {
            room.setUpdateAt(new Date());
            roomDAO.modifyRoomSize(room);
            return 200;
        } else {
            return 406;
        }
    }

    @Override
    public int createRoom(Room room) {
        Room duplicate = roomDAO.findRoom(room.getId());
        if (duplicate == null || duplicate.getId() == null || ("".equals(duplicate.getId()))) {
            room.setCreateAt(new Date());
            roomDAO.createRoom(room);
            return 200;
        } else {
            return 502;
        }
    }

}
