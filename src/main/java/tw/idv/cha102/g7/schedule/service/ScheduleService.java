package tw.idv.cha102.g7.schedule.service;

import tw.idv.cha102.g7.schedule.vo.Schedule;

import java.sql.Date;
import java.util.List;

public interface ScheduleService {

    /**
     * 依行程ID，查詢單一行程內容
     */
    public Schedule findById(Integer schId);

    /**
     * 查詢單一行程，對行程內容進行修改
     */
    public Schedule updateById(Integer schId, Schedule schedule);

    /**
     * 刪除一筆行程
     */
    public Schedule deleteById(Integer schId);

    /**
     * 新增一筆行程
     */
    public Schedule add(Schedule schedule);

    /**
     * 查詢所有行程清單
     */
    public List<Schedule> getAllSchedules();


    public List<Schedule> findBetweenDate(Date schStart, Date schEnd);

    public List<Schedule> findBySchName(String schName);
}
