package tw.idv.cha102.g7.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleReport;
import tw.idv.cha102.g7.schedule.repo.ScheduleReportRepository;

import java.util.List;

public interface ScheduleReportService {

    // 查詢所有被檢舉行程清單
    public List<ScheduleReport> findAll();
    // 查看行程詳情

    // 屏蔽被檢舉的行程
    public String hideById(Integer schId);

    // 刪除被檢舉的行程
    public String deleteReportedSchedule(Integer schId);

    // 修改/刪除被檢舉的行程標籤
//    public String deleteReportedTagsFromSchedule(Schedule schedule);

    // 修改檢舉處理狀態(0:審核中 1:已處理 2:已撤銷)
    public String modifyReportStatus(ScheduleReport report);

}
