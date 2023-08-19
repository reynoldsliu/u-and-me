package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleManageService;

import java.util.List;

@Component
public class ScheduleManageServiceImpl implements ScheduleManageService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public List<Schedule> getAllByMemId(Integer memId) {
        List<Schedule> schedules = repository.findByMemId(memId);
        return schedules;
    }

    @Override
    public String add(Schedule schedule) {
        repository.save(schedule);
        return "新增成功";
    }

    @Override
    public String delete(Integer schId) {
        repository.deleteById(schId);
        return "刪除成功";
    }

    @Override
    public String updateById(Integer schId, Schedule schedule) {
        // sche 為資料庫中已存在的行程，sche存在才能更新，否則回傳查詢不到資料
        Schedule sche = repository.findById(schId).orElse(null);
        if (sche != null) {  // schedule為欲修改的行程資料
            sche.setSchName(schedule.getSchName());
//            sche.setSchStart(schedule.getSchStart());
//            sche.setSchEnd(schedule.getSchEnd());
//            sche.setSchCost(schedule.getSchCost());
//            sche.setSchPub(schedule.getSchPub());
//            sche.setSchCopy(schedule.getSchCopy());
            repository.save(sche);
            return "更新成功！";
        } else {
            return "更新失敗，查詢的行程不存在";
        }
    }

}
