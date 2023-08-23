package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleReport;
import tw.idv.cha102.g7.schedule.repo.ScheduleReportRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleReportService;

import java.util.List;

@Component
public class ScheduleReportServiceImpl implements ScheduleReportService {

    @Autowired
    ScheduleReportRepository reportRepository;

    @Autowired
    private ScheduleRepository repository;


    @Override
    public List<ScheduleReport> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public String hideById(Integer schId) {
        // 先查詢此id的行程是否存在，再進行行程公開設定
        var schedule = repository.findById(schId);
        if (schedule.isPresent()) {
            schedule.get().setSchPub((byte) 0);
            // 修改行程公開權限為0:私人檢視
            repository.save(schedule.get());
            return "屏蔽成功！";
        }
        return "操作失敗，此行程不存在！";
    }

    @Override
    public String deleteReportedSchedule(Integer schId) {
        if (repository.findById(schId).isPresent()) {
            repository.deleteById(schId);
            return "刪除成功!";
        }
        return "刪除失敗，找不到此行程!";
    }

//    @Override
//    public String deleteReportedTagsFromSchedule(Schedule schedule) {
//        return "刪除成功!";
//    }

    @Override
    public String modifyReportStatus(ScheduleReport report) {
        var existReport = reportRepository.findById(report.getSchRepId());
        if (existReport.isPresent()) {
            existReport.get().setSchRepSta(report.getSchRepSta());
            existReport.get().setHostId(report.getHostId());
            reportRepository.save(existReport.get());
            return "修改成功！";
        }
        return "修改失敗！";
    }


}
