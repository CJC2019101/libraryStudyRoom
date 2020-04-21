package cn.cqucc.library.service.chair.dao;

import cn.cqucc.library.model.chair.Chair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/21 16:24
 * @Description cn.cqucc.library.service.chair.dao
 */
@Mapper
public interface ICKChairDAO {

    List<Chair> occupyChairs(Chair chair);
}
