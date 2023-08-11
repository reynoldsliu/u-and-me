package tw.idv.cha102.g7.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import tw.idv.cha102.g7.schedule.dao.ScheduleDao;
import tw.idv.cha102.g7.schedule.vo.Schedule;

import java.util.List;

public interface ScheduleService {

    public Schedule getById(Integer schId);

    public void updateById(Integer schId, Schedule schedule);

    public void deleteById(Integer schId);

    public void insert(Schedule schedule);

    public List<Schedule> getAll();

}
