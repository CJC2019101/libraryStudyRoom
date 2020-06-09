package cn.cqucc.library.service.chair.bo;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.model.chair.req.ChairReq;
import cn.cqucc.library.model.chair.resp.ChairResp;
import cn.cqucc.library.model.room.Room;
import cn.cqucc.library.service.chair.api.ICKChairAPI;
import cn.cqucc.library.service.chair.dao.ICKChairDAO;
import cn.cqucc.library.service.room.dao.ICKRoomDAO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author JianfeiChen
 * @date 2020/4/21 16:23
 * @Description
 */
@Service
public class CKChairBO implements ICKChairAPI {

    @Autowired
    ICKChairDAO chairDAO;

    @Autowired
    ICKRoomDAO roomDAO;

    @Override
    public List<Chair> occupyChairs(Chair chair) {
        List<Chair> chairs = new ArrayList<>();
        List<Chair> adminChairs = chairDAO.adminOccupyChairs(chair);
        List<Chair> studentChairs = chairDAO.occupyChairs(chair);
        chairs.addAll(adminChairs);
        chairs.addAll(studentChairs);
        return chairs;
    }

    @Override
    public int selectChair(List<Chair> chairs) {
        if (!chairs.get(0).getUserId().equals("admin")) {
            // 被选中的座位数
            int selectedChairCount = chairs.size();
            // 已经选中的座位数
            int chairCount = chairDAO.selectChairAmount(chairs.get(0).getUserId());
            if ((selectedChairCount + chairCount) > 1) {
                return 502;
            }
        }
        for (Chair chair : chairs) {
            chair.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            chair.setCreateAt(new Date());
            chairDAO.selectChair(chair);
        }
        return 200;
    }

    @Override
    public int selectChair(Chair chair) {
        chair.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        chair.setCreateAt(new Date());
        chair.setUpdateAt(new Date());
        chair.setIsOccupy(true);
        chair.setIsValid(true);
        chairDAO.selectChair(chair);
        return 200;
    }

    @Override
    public void cancelChairs(List<Chair> chairs) {
        for (Chair chair : chairs) {
            chair.setUpdateAt(new Date());
        }
        chairDAO.cancelChairs(chairs);
    }

    @Override
    public PageInfo getUserInfoOfSelectedChair(String account, Integer pageNumber) {
        PageHelper.startPage(pageNumber, 10);
        List<Chair> chairs = chairDAO.getUserInfoOfSelectedChair(account);
        return new PageInfo(chairs);
    }

    @Override
    public List<ChairReq> selectAllChairs(ChairResp chairResp) {
        Room room = roomDAO.findRoom(chairResp.getRoomId() + "");
        if (room == null) {
            throw new RuntimeException("没有该教室");
        }
        int roomWidth = room.getRoomWidth();
        int roomLong = room.getRoomLong();
        List<ChairReq> chairReqList = new ArrayList<>();
        for (int i = 1; i < roomWidth; i++) {
            for (int j = 1; j < roomLong; j++) {
                ChairReq chairReq = new ChairReq();
                chairReq.setCrow(i);
                chairReq.setCell(j);
                chairReqList.add(chairReq);
            }
        }
        List<ChairReq> chairReqs = chairDAO.allOccupyChairs(chairResp);
        boolean b = chairReqList.removeAll(chairReqs);
        return chairReqList;
    }

    @Override
    public List<Chair> selectChairHistory(String userId) {

        return chairDAO.selectChairHistory(userId);
    }
}
