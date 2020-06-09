package cn.cqucc.library.service.chair.job;

import cn.cqucc.library.model.chair.Chair;
import cn.cqucc.library.model.chair.directory.CKChairDirectory;
import cn.cqucc.library.model.chair.resp.SignChairResp;
import cn.cqucc.library.service.chair.dao.ICKChairDAO;
import cn.cqucc.library.utils.annotation.description.Description;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Scheduled(cron = "0 0/20 *  * * ? ")
    @Description(description = "预约后不签到释放座位选中的座位状态")
    public void updateChairsSignStatus() {
        Long durationOf30minsInMiles = TimeUnit.SECONDS.toMillis(1800);

        System.out.println("更新座位状态啦！！！！");
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("HH");
        int hours = Integer.parseInt(f.format(date));
        if (hours >= 8 && hours <= 12) {
            System.out.println("当前时间:" + hours + "时,处理早上的订座逾期");
            List<Chair> chairList = chairDAO.selectAllChair(CKChairDirectory.ChairStatus.morning);
            for (Chair c : chairList) {
                if(date.getTime()-c.getCreateAt().getTime()>durationOf30minsInMiles){
                    SignChairResp signChairResp = new SignChairResp();
                    signChairResp.setChairId(c.getId());
                    signChairResp.setSignStatus(2);
                    chairDAO.updateChairSignStatus(signChairResp);
                    chairDAO.updateChairsStatus(c.getId());
                }
            }
        } else if (hours > 12 && hours <= 18) {
            System.out.println("当前时间:" + hours + "时,处理下午的订座逾期");
            List<Chair> chairList = chairDAO.selectAllChair(CKChairDirectory.ChairStatus.afternoon);
            System.out.println(chairList);
            for (Chair c : chairList) {
                if(date.getTime()-c.getCreateAt().getTime()>durationOf30minsInMiles){
                    SignChairResp signChairResp = new SignChairResp();
                    signChairResp.setChairId(c.getId());
                    signChairResp.setSignStatus(2);
                    chairDAO.updateChairSignStatus(signChairResp);
                    chairDAO.updateChairsStatus(c.getId());
                }
            }
        } else if (hours > 18 && hours <= 22) {
            System.out.println("当前时间:" + hours + "时,处理晚上的订座逾期");
            List<Chair> chairList = chairDAO.selectAllChair(CKChairDirectory.ChairStatus.night);
            for (Chair c : chairList) {
                if(date.getTime()-c.getCreateAt().getTime()>durationOf30minsInMiles){
                    SignChairResp signChairResp = new SignChairResp();
                    signChairResp.setChairId(c.getId());
                    signChairResp.setSignStatus(2);
                    chairDAO.updateChairSignStatus(signChairResp);
                    chairDAO.updateChairsStatus(c.getId());
                }
            }
        }
////        chairDAO.
//        chairDAO.updateAllChairsStatus(CKChairDirectory.ChairStatus.allDay);
    }
}
