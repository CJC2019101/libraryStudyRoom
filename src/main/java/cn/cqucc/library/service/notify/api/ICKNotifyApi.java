package cn.cqucc.library.service.notify.api;

import cn.cqucc.library.model.notify.Notify;
import cn.cqucc.library.model.notify.req.NotifyFindAllReq;
import com.github.pagehelper.PageInfo;

/**
 * @author JianfeiChen
 * @date 2020/5/9 21:28
 * @Description cn.cqucc.library.service.notify
 */
public interface ICKNotifyApi {
    void addNotify(Notify notify);

    Notify hasDubiousNotify(String account);

    PageInfo findAllNotify(NotifyFindAllReq account);

    void lookNotify(Notify notify);

    Notify findNotify(String id);
}
