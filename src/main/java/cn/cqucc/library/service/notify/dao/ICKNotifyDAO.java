package cn.cqucc.library.service.notify.dao;

import cn.cqucc.library.model.notify.Notify;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JianfeiChen
 * @date 2020/5/9 21:31
 * @Description cn.cqucc.library.service.notify.dao
 */
@Mapper
public interface ICKNotifyDAO {
    void addNotify(Notify notify);

    Notify hasDubiousNotify(String account);
}
