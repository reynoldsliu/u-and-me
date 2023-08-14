package tw.idv.cha102.g7.schedule.service;

import tw.idv.cha102.g7.schedule.entity.Schedule;

import java.sql.Date;
import java.util.List;

public interface ScheduleService {

    /**
     * 依行程ID，查詢單一行程內容
     */
    public Schedule getById(Integer schId);

    /**
     * 查詢單一行程，對行程內容進行修改
     */
    public String updateById(Integer schId, Schedule schedule);

    /**
     * 屏蔽一筆行程
     */
    public void hideById(Integer schId);

    /**
     * 新增一筆行程
     */
    public void add(Schedule schedule);

    /**
     * 查詢使用者自己的所有行程清單
     */
    public List<Schedule> getAllByMemId(Integer memId);

    /**
     * 查詢所有公開行程清單，並依照起始日期排序
     */
    public List<Schedule> getAllPublic();

    public List<Schedule> findBetweenDate(Date schStart, Date schEnd);

    public List<Schedule> findBySchName(String schName);

    public List<Schedule> getAll();
}
