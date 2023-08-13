package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleService;
import tw.idv.cha102.g7.schedule.entity.Schedule;

import java.sql.Date;
import java.util.List;

@Component
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public Schedule findById(Integer schId) {
        // 待增加查詢不到的例外處理
        return repository.getById(schId);
    }

    @Override
    public Schedule updateById(Integer schId, Schedule schedule) {
        // 已存在才更新
        return repository.save(schedule);
    }

    @Override
    public Schedule deleteById(Integer schId) {
        repository.deleteById(schId);
        return null;
    }

    @Override
    public Schedule add(Schedule schedule) {
        repository.save(schedule);
        return null;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        // 需確認此行程公開權限為公開才可供查詢
        List<Schedule> schedules = repository.findAll();
        return schedules;
    }


    public List<Schedule> findBetweenDate(Date schStart, Date schEnd){
        return repository.findBetweenDate(schStart, schEnd);
    }

    public List<Schedule> findBySchName(String schName){
        return repository.findBySchNameContaining(schName);
    }

}
