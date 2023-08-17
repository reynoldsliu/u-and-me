package tw.idv.cha102.g7.schedule.service;

import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;

import java.sql.Date;
import java.util.List;

public interface ScheduleService {

    // 查詢所有公開行程清單，並依照起始日期排序
    public List<Schedule> findAllPublic();

    // 依照行程名稱，查詢所有公開行程清單，並依照起始日期排序
    public List<Schedule> findBySchName(String schName);

    // 依照行程開始日期及結束日期，查詢所有期限內的公開行程清單，並依照起始日期排序
    public List<Schedule> findBetweenDate(Date schStart, Date schEnd);

    // 查詢使用者自己所有建立過的行程清單
    public List<Schedule> getAllByMemId(Integer memId);

    // 依行程ID，查詢單一行程內容
    public Schedule getById(Integer schId);

    // 新增一筆行程
    public void add(Schedule schedule);

    // 查詢單一行程後，對行程內容進行修改
    public String updateById(Integer schId, Schedule schedule);

    // 屏蔽一筆行程
    public void hideById(Integer schId);

    // 刪除一筆行程
    public void deleteById(Integer schId);

    // 查詢所有行程清單
    public List<Schedule> getAll();

    // 測試一對多查詢行程及細節
//    public List<ScheduleDetail> getOneScheDetail(Integer schId) ;
}
