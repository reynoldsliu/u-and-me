package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.repo.ScheduleReportRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleReportService;

@Component
public class ScheduleReportServiceImpl implements ScheduleReportService {

    @Autowired
    ScheduleReportRepository reportRepository;

    @Autowired
    ScheduleRepository repository;


    @Override
    public void hideById(Integer schId) {
        // 先查詢此id的行程是否存在，再進行行程公開設定
        var schedule = repository.findById(schId);
        if (schedule.isPresent()) {
            schedule.get().setSchPub(0);
            // 修改行程公開權限為0:私人檢視
            repository.save(schedule.get());
        }
    }
}
