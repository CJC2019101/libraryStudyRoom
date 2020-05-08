package cn.cqucc.library.service.chair.job;

import cn.cqucc.library.model.chair.directory.CKChairDirectory;
import cn.cqucc.library.service.chair.dao.ICKChairDAO;
import cn.cqucc.library.utils.annotation.description.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author JianfeiChen
 * @date 2020/4/26 13:54
 * @Description 更新座位状态的定时任务类
 */
@Component
public class ScheduleJob {

    @Autowired
    ICKChairDAO chairDAO;

    @Scheduled(cron = "40 55 11 * * ? ")
    @Description(description = "上午时间：“11:55:40”时更新选中状态为上午的座位")
    public void updateChairMorningsStatus() {
        System.out.println("更新座位状态啦！！！！");
        chairDAO.updateChairMorningStatus(CKChairDirectory.ChairStatus.morning);
    }

    @Scheduled(cron = "40 55 17 * * ? ")
    @Description(description = "下午时间：“17:55:40”时更新选中状态为下午的座位")
    public void updateChairAfternoonStatus() {
        System.out.println("更新座位状态啦！！！！");
        chairDAO.updateChairAfternoonStatus(CKChairDirectory.ChairStatus.afternoon);
    }

    @Scheduled(cron = "40 20 21 * * ? ")
    @Description(description = "晚上时间：“21:20:40”时更新选中状态为晚上的座位")
    public void updateChairNightStatus() {
        System.out.println("更新座位状态啦！！！！");
        chairDAO.updateChairNightStatus(CKChairDirectory.ChairStatus.night);
    }

    @Scheduled(cron = "40 59 23  * * ? ")
    @Description(description = "晚上时间：“23:55:40”时更新所有被学生选中的座位状态")
    public void updateAllChairsStatus() {
        System.out.println("更新座位状态啦！！！！");
        chairDAO.updateAllChairsStatus(CKChairDirectory.ChairStatus.allDay);
    }
}
