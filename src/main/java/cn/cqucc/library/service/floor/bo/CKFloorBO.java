package cn.cqucc.library.service.floor.bo;

import cn.cqucc.library.model.floor.Floor;
import cn.cqucc.library.service.floor.api.ICKFloorApi;
import cn.cqucc.library.service.floor.dao.ICKFloorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/15 18:18
 * @Description cn.cqucc.library.service.floor.bo
 */
@Service
public class CKFloorBO implements ICKFloorApi {

    @Autowired
    ICKFloorDAO floorDAO;

    @Override
    public List<Floor> findRooms(int floorNumber) {
        return floorDAO.findRooms(floorNumber);
    }

}
