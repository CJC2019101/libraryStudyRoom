package cn.cqucc.library.service.chair.bo;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.service.chair.api.ICKChairAPI;
import cn.cqucc.library.service.chair.dao.ICKChairDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return chairDAO.occupyChairs(chair);
    }
}
