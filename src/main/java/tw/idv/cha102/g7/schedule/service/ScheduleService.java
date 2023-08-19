package tw.idv.cha102.g7.schedule.service;

import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagDTO;

import java.sql.Date;
import java.util.List;

public interface ScheduleService {

    // 查詢所有公開行程清單，並依照起始日期排序
    public List<Schedule> findAllPublic();

    // 依照行程名稱，查詢所有公開行程清單，並依照起始日期排序
    public List<Schedule> findBySchName(String schName);

    // 依照行程開始日期及結束日期，查詢所有期限內的公開行程清單，並依照起始日期排序
    public List<Schedule> findBetweenDate(Date schStart, Date schEnd);

    // 依行程ID，查詢單一行程
    public Schedule getById(Integer schId);

    // 新增一筆行程
    public void add(Schedule schedule);

    // 屏蔽一筆行程
    public void hideById(Integer schId);

    // 刪除一筆行程
    public void deleteById(Integer schId);

    // 查詢所有行程清單(留著，暫時沒用到)
    public List<Schedule> getAll();

    // 測試一對多查詢行程及細節
    public Schedule getOneById(Integer schId);

    // 從單一行程中查詢對應標籤
    public List<ScheduleTagDTO> findTagsInOneSchdule(Integer schId);
}
