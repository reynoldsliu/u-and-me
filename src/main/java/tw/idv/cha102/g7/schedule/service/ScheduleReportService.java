package tw.idv.cha102.g7.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import tw.idv.cha102.g7.schedule.repo.ScheduleReportRepository;

public interface ScheduleReportService {

    // 屏蔽一筆行程
    public void hideById(Integer schId);
}
