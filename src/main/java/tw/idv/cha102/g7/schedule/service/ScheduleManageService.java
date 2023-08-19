package tw.idv.cha102.g7.schedule.service;

import tw.idv.cha102.g7.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleManageService {

    // 查詢使用者自己所有建立過的行程清單
    public List<Schedule> getAllByMemId(Integer memId);

    // 新增一筆行程(包含選擇出發及結束日期、目的地標籤、行程名稱)
    public String add(Schedule schedule);

    // 刪除一筆行程
    public String delete(Integer schId);


    // 查詢單一行程後，對行程內容進行修改
    // 修改行程公開權限(私密、透過連結分享、公開)
    // 行程共同編輯成員及權限設定(可檢視、可編輯、新增及移除共編成員，透過連結分享邀請成員共編)
    public String updateById(Integer schId, Schedule schedule);

}
