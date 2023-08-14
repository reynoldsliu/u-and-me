package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.schedule.entity.Schedule;

import java.sql.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    /**
     * 依照行程名稱，查詢所有公開行程清單
     * */
    @Query(value = "SELECT * FROM schedules where sch_name like %?1% And sch_pub = 2", nativeQuery=true)
    public List<Schedule> findBySchNameContaining(String schName);


    /**
     * 依照行程開始日期及結束日期，查詢所有期限內的公開行程清單
     * */
    @Query(value = "SELECT * FROM schedules WHERE sch_start >= ?1 AND sch_end <= ?2 And sch_pub = 2 ORDER BY sch_start", nativeQuery = true)
    public List<Schedule> findBetweenDate(Date schStart, Date schEnd);

    /**
     * 查詢所有公開行程清單，並依照日期排序
     * */
    @Query(value = "SELECT * FROM schedules WHERE sch_pub = 2 ORDER BY sch_start", nativeQuery = true)
    public  List<Schedule> findOrderBySchStart();

    /**
     * 查詢使用者自己的所有行程清單
     * */
    public List<Schedule> findByMemId(Integer memId);


}
