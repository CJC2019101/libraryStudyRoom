package cn.cqucc.library.service.floor.api;

import cn.cqucc.library.model.floor.Floor;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/15 18:16
 * @Description
 */
public interface ICKFloorApi {
    List<Floor> findRooms(int floorNumber);
}
