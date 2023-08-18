package tw.idv.cha102.g7.activity.service;

import tw.idv.cha102.g7.activity.entity.Activity;

import java.util.List;

public interface ActivityService {

    // 依活動Id,查詢單一活動內容
    public Activity getById(Integer activId);

    // 依活動名稱關鍵字模糊比對查詢行程
    List<Activity> findByActivName(String activName);

    // 依活動內容關鍵字模糊比對查詢行程
    List<Activity> findByActivCon(String activCon);
}
