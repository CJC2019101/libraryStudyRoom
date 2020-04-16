package cn.cqucc.library.service.floor.dao;

import cn.cqucc.library.model.floor.Floor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/15 18:19
 * @Description cn.cqucc.library.service.floor.dao
 */
@Mapper
public interface ICKFloorDAO {
    List<Floor> findRooms(int floorNumber);
}
