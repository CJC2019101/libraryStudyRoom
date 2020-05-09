package cn.cqucc.library.service.notify.bo;

import cn.cqucc.library.model.notify.Notify;
import cn.cqucc.library.service.notify.api.ICKNotifyApi;
import cn.cqucc.library.service.notify.dao.ICKNotifyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        notify.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        notifyDAO.addNotify(notify);
    }

    @Override
    public Notify hasDubiousNotify(String account) {
        return notifyDAO.hasDubiousNotify(account);
    }
}
