package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleReport;
import tw.idv.cha102.g7.schedule.repo.ScheduleReportRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleReportService;

import java.util.List;

@Service
public class ScheduleReportServiceImpl implements ScheduleReportService {

    @Autowired
    private ScheduleReportRepository reportRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void insert(ScheduleReport scheduleRep) {
        reportRepository.save(scheduleRep);
    }

    @Override
    public void update(Integer schRepId, ScheduleReport scheduleRep) {
        var existReport = reportRepository.findById(schRepId);
        if (existReport.isPresent()) {
            reportRepository.save(scheduleRep);
        }
    }

    @Override
    public List<ScheduleReport> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public void hideById(Integer schId) {
        // 先查詢此id的行程是否存在，再進行行程公開權限設定
        var schedule = scheduleRepository.findById(schId);
        if (schedule.isPresent()) {
            // 修改行程公開權限為0:私人檢視
            schedule.get().setSchPub((byte) 0);
            scheduleRepository.save(schedule.get());
        }
    }

    @Override
    public void modifyStatus(Integer schRepId, Short schRepSta, Integer hostId) {
        var existReport = reportRepository.findById(schRepId);
        if (existReport.isPresent()) {
            existReport.get().setSchRepSta(schRepSta);
            existReport.get().setHostId(hostId);
            reportRepository.save(existReport.get());
        }
    }

    // 要刪除被參照到的行程前，其關聯FK的資料要先全數清空
    // 被檢舉的行程不存在，要怎麼處理行程檢舉清單中，行程ID關聯的問題?
    @Override
    @Transactional
    public void deleteReportedSchedule(Integer schId) {
        var existSchedule = scheduleRepository.findById(schId);
        if (existSchedule.isPresent()) {
            // TODO
            // 刪除關聯到的行程標籤清單
            // 刪除關聯到的行程細節
            // 刪除關聯到的活動推薦行程
            // 刪除關聯到的揪團
            // 會員會查不到被刪除的行程
            // 刪除了行程，要怎麼查詢行程檢舉的部分?
            // 最後再刪除行程
            scheduleRepository.deleteById(schId);
        }
    }
}
