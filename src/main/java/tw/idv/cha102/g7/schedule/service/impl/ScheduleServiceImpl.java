package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.dao.ScheduleDao;
import tw.idv.cha102.g7.schedule.service.ScheduleService;
import tw.idv.cha102.g7.schedule.vo.Schedule;

import java.util.List;

@Component
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public Schedule getById(Integer schId) {
        return scheduleDao.getById(schId);
    }

    @Override
    public void updateById(Integer schId, Schedule schedule) {
        scheduleDao.updateById(schId, schedule);
    }

    @Override
    public void deleteById(Integer schId) {
        scheduleDao.deleteById(schId);
    }

    @Override
    public void insert(Schedule schedule) {
        scheduleDao.insert(schedule);
    }

    @Override
    public List<Schedule> getAll() {
        List<Schedule> schedules = scheduleDao.getAll();
        return schedules;
    }
}
