package tw.idv.cha102.g7.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.cha102.g7.activity.entity.Activity;
import tw.idv.cha102.g7.schedule.entity.Schedule;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {


    // 依照活動名稱關鍵字，查詢所有在架上活動清單
    @Query(value = "SELECT * FROM activity1 where activ_name like %?1% AND activ_sta = 1", nativeQuery=true)
    public List<Activity> findByActivName(String activName);

    // 依照活動內容關鍵字，查詢所有在架上活動清單
    @Query(value = "SELECT * FROM activity1 where activ_con like %?1% AND activ_sta = 1", nativeQuery=true)
    List<Activity> findByActivCon(String activCon);



}
