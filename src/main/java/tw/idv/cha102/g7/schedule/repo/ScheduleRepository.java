package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagDTO;

import java.sql.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    // 查詢所有公開行程清單，並依照起始日期排序
    @Query(value = "SELECT * FROM schedules WHERE sch_pub = 2 ORDER BY sch_start", nativeQuery = true)
    public List<Schedule> findOrderBySchStart();

    // 依照行程名稱，查詢所有公開行程清單，並依照起始日期排序
    @Query(value = "SELECT * FROM schedules where sch_name like %?1% And sch_pub = 2 ORDER BY sch_start", nativeQuery = true)
    public List<Schedule> findBySchName(String schName);

    // 依照行程開始日期及結束日期，查詢所有期限內的公開行程清單，並依照起始日期排序
    @Query(value = "SELECT * FROM schedules WHERE sch_start >= ?1 AND sch_end <= ?2 And sch_pub = 2 ORDER BY sch_start", nativeQuery = true)
    public List<Schedule> findBetweenDate(Date schStart, Date schEnd);

    // 查詢使用者自己所有建立過的行程清單
    public List<Schedule> findByMemId(Integer memId);

//    @Query(value = "SELECT s.sch_id, sch_name, mem_id, sch_start, sch_end, sch_pub, sch_copy, sch_cost, " +
//            "schde_id, attr_id, schde_starttime, schde_staytime, schde_transtime, schde_trans, " +
//            "schde_costname, schde_cost, schde_remark FROM schedules s " +
//            "JOIN schedule_de sd ON s.sch_id = sd.sch_id " +
//            "WHERE s.sch_id = ?1 ORDER BY schde_starttime", nativeQuery = true)
    @Query(value = "SELECT * FROM schedules s " +
            "JOIN schedule_de sd ON s.sch_id = sd.sch_id " +
            "WHERE s.sch_id = ?1 ORDER BY schde_starttime asc", nativeQuery = true)
    public Schedule findByIdOrderByStarttime(Integer schId);

    @Query(value = "SELECT s.sch_id schId, sch_name schName, mem_id memId, sch_start schStart, sch_end schEnd, sch_pub schPub, sch_copy schCopy, sch_cost schCost, st.schtag_id schTagId, st.schtag_name schTagName " +
            "FROM schedules s " +
            "JOIN schedule_tag_list stl ON s.sch_id = stl.sch_id " +
            "JOIN schedule_tag st ON stl.schtag_id = st.schtag_id "+
            "WHERE s.sch_id = ?1", nativeQuery = true)
    public List<Object[]> findTagsByOneSchedule(Integer schId);




}
