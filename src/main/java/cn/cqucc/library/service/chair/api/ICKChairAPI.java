package cn.cqucc.library.service.chair.api;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.model.chair.req.ChairReq;
import cn.cqucc.library.model.chair.resp.ChairResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author JianfeiChen
 * @date 2020/4/21 16:22
 * @Description 城科图书馆座位操作API
 */
public interface ICKChairAPI {
    List<Chair> occupyChairs(Chair chair);

    int selectChair(List<Chair> chairs);

    int selectChair(Chair chair);

    void cancelChairs(List<Chair> chairs);

    PageInfo getUserInfoOfSelectedChair(String account, Integer pageNumber);

    List<ChairReq> selectAllChairs(ChairResp chairResp);

    List<Chair> selectChairHistory(String userId);
}
