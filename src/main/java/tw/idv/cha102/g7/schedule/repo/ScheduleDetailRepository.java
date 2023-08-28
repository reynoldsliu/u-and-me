package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;

import java.util.List;

@Repository
public interface ScheduleDetailRepository extends JpaRepository<ScheduleDetail, Integer> {

    // 查詢單一行程的所有行程細節
    @Query(value = "SELECT * FROM schedule_de WHERE sch_id = ?1 ORDER BY schde_starttime", nativeQuery = true)
    public List<ScheduleDetail> findBySchId(Integer schId);
}
