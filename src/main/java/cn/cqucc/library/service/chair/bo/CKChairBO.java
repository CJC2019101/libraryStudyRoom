package cn.cqucc.library.service.chair.bo;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.service.chair.api.ICKChairAPI;
import cn.cqucc.library.service.chair.dao.ICKChairDAO;
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
            if ((selectedChairCount + chairCount) > 4) {
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
}
