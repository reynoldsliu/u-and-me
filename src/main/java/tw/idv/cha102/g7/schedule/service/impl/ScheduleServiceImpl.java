package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import java.sql.Date;
import java.util.List;

@Component
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public Schedule getById(Integer schId) {
        Schedule schedule = repository.findById(schId).orElse(null);
        return schedule;
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

    @Override
    public void hideById(Integer schId) {
        // 先查詢此id的行程是否存在，再進行行程公開設定
        var schedule = repository.findById(schId);
        if(schedule.isPresent()) {
            schedule.get().setSchPub(0);
            // 修改行程公開權限為0:私人檢視
            repository.save(schedule.get());
        }
    }

    @Override
    public void add(Schedule schedule) {
        repository.save(schedule);
    }

    @Override
    public List<Schedule> getAllByMemId(Integer memId) {
        List<Schedule> schedules = repository.findByMemId(memId);
        return schedules;
    }

    public List<Schedule> getAllPublic(){
        List<Schedule> schedules = repository.findOrderBySchStart();
        return schedules;
    }


    public List<Schedule> findBetweenDate(Date schStart, Date schEnd) {
        return repository.findBetweenDate(schStart, schEnd);
    }

    public List<Schedule> findBySchName(String schName) {
        return repository.findBySchName(schName);
    }

    public List<Schedule> getAll(){
        return repository.findAll();
    }

}
