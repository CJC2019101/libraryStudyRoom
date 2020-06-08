package cn.cqucc.library.service.chair.dao;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.model.chair.req.ChairReq;
import cn.cqucc.library.model.chair.resp.ChairResp;
import cn.cqucc.library.model.room.Room;
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

    List<Chair> adminOccupyChairs(Chair chair);

    List<ChairReq> allOccupyChairs(ChairResp chairResp);

    void selectChair(Chair chairs);

    int selectChairAmount(String account);

    void updateChairMorningStatus(int morning);

    void updateChairAfternoonStatus(int afternoon);

    void updateChairNightStatus(int night);

    void updateAllChairsStatus(int allDay);

    void cancelChairs(List<Chair> chair);

    List<Chair> getUserInfoOfSelectedChair(String account);

    int getUnvalidChairCount(Room room);

    List<Chair> selectChairHistory(String userId);
}
