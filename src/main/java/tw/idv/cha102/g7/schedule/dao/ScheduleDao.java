package tw.idv.cha102.g7.schedule.dao;

import com.example.demo.schedule.vo.Schedule;

import java.util.List;

// 尚未改版
public interface ScheduleDao {

    public Schedule getById(Integer schId);

    public void updateById(Integer schId, Schedule schedule);

    public void deleteById(Integer schId);

    public void insert(Schedule schedule);

    public List<Schedule> getAll();
}
