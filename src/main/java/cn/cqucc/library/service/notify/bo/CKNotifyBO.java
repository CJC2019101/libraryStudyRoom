package cn.cqucc.library.service.notify.bo;

import cn.cqucc.library.model.notify.Notify;
import cn.cqucc.library.model.notify.req.NotifyFindAllReq;
import cn.cqucc.library.service.notify.api.ICKNotifyApi;
import cn.cqucc.library.service.notify.dao.ICKNotifyDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author JianfeiChen
 * @date 2020/5/9 21:29
 * @Description cn.cqucc.library.service.notify.bo
 */
@Service
public class CKNotifyBO implements ICKNotifyApi {

    @Autowired
    ICKNotifyDAO notifyDAO;

    @Override
    public void addNotify(Notify notify) {
        notify.setCreateAt(new Date());
        if (notify.getId() == null || ("".equals(notify.getId()))) {
            notify.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            notifyDAO.addNotify(notify);
        } else {
            notifyDAO.updateNotify(notify);
        }
    }

    @Override
    public Notify hasDubiousNotify(String account) {
        return notifyDAO.hasDubiousNotify(account);
    }

    @Override
    public PageInfo findAllNotify(NotifyFindAllReq notifyInfo) {
        List<Notify> notifies = notifyDAO.findAllNotify();
        Collections.sort(notifies);
        for (Notify notify : notifies) {
            notify.setAccount(notifyInfo.getAccount());
        }
        PageHelper.startPage(notifyInfo.getPageNumber(), 10);
        return new PageInfo(notifies);
    }

    @Override
    public void lookNotify(Notify notify) {
        notifyDAO.lookNotify(notify);
    }

    @Override
    public Notify findNotify(String id) {
        return notifyDAO.findNotify(id);
    }
}
