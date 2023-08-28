package tw.idv.cha102.g7.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleReport;
import tw.idv.cha102.g7.schedule.repo.ScheduleReportRepository;

import java.util.List;

public interface ScheduleReportService {

    // 新增一筆檢舉行程的資料
    public void insert(ScheduleReport scheduleRep);

    // 修改檢舉內容
    public void update(Integer schRepId, ScheduleReport scheduleRep);

    // 查詢所有被檢舉行程清單
    public List<ScheduleReport> findAll();

    // 屏蔽被檢舉的行程
    public void hideById(Integer schId);

    // 修改檢舉處理狀態(0:審核中 1:已處理 2:已撤銷)
    public void modifyStatus(Integer schRepId, Short schRepSta,  Integer hostId);

    // 刪除被檢舉的行程(待討論)
    public void deleteReportedSchedule(Integer schId);

    // 修改/刪除被檢舉的行程標籤

}
