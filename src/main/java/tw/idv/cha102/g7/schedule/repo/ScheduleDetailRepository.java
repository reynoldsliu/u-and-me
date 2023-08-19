package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;

import java.util.List;

@Repository
public interface ScheduleDetailRepository extends JpaRepository<ScheduleDetail, Integer> {
    // 一對多查詢:查詢單一行程的細節
    @Query(value = "SELECT * FROM schedules s " +
            "JOIN schedule_de sd ON s.sch_id = sd.sch_id " +
            "WHERE s.sch_id = ?1 ORDER BY sd.schde_starttime", nativeQuery = true)
    public List<ScheduleDetail> findBySchId(Integer schId);
}
