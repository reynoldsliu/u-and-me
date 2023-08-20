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

    // 測試一對多查詢行程及細節
    public Schedule getOneById(Integer schId);

    // 從單一行程中查詢對應標籤
    public List<ScheduleTagDTO> findTagsInOneSchdule(Integer schId);

    // 查詢所有行程清單(留著，暫時沒用到)
    public List<Schedule> getAll();

    /***
     * 以上為搜瀏覽公開行程相關功能
     * 以下為管理行程功能
     */

    // 查詢使用者自己所有建立過的行程清單
    public List<Schedule> getAllByMemId(Integer memId);

    // 新增一筆行程(包含選擇出發及結束日期、目的地標籤、行程名稱)
    public void create(Schedule schedule);

    // 刪除一筆行程
    public void delete(Integer schId);

    // 查詢單一行程後，對行程內容進行修改
    // 修改行程公開權限(私密、透過連結分享、公開)
    // 行程共同編輯成員及權限設定(可檢視、可編輯、新增及移除共編成員，透過連結分享邀請成員共編)
    public String edit(Integer schId, Schedule schedule);

    // 屏蔽一筆行程
    public void hide(Integer schId);

}
