package tw.idv.cha102.g7.schedule.repo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagDTO;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.entity.TestDTO;

import java.util.List;

@Repository
public interface ScheduleTagRepository extends JpaRepository<ScheduleTag, Integer> {

    public List<ScheduleTag> findBySchTagNameContaining(String schTagName);

    @Query(value = "SELECT s.sch_id schId, s.sch_name schName, " +
            "s.mem_id memId, s.sch_start schStart, s.sch_end schEnd, " +
            "s.sch_pub schPub, s.sch_copy schCopy, s.sch_cost schCost, " +
            "st.schtag_id schTagId, st.schtag_name schTagName " +
            "FROM schedules s " +
            "JOIN schedule_tag_list stl ON s.sch_id = stl.sch_id " +
            "JOIN schedule_tag st ON stl.schtag_id = st.schtag_id " +
            "WHERE st.schtag_id =  ?1 AND sch_pub = 2 ORDER BY s.sch_start", nativeQuery = true)
    public List<Object[]> findSchedulesBySchTagId(Integer schTagId);


    @Query(value = "SELECT s.sch_id schId, s.sch_name schName, " +
            "s.mem_id memId, s.sch_start schStart, s.sch_end schEnd, " +
            "s.sch_pub schPub, s.sch_copy schCopy, s.sch_cost schCost, " +
            "st.schtag_id schTagId, st.schtag_name schTagName " +
            "FROM schedules s " +
            "JOIN schedule_tag_list stl ON s.sch_id = stl.sch_id " +
            "JOIN schedule_tag st ON stl.schtag_id = st.schtag_id " +
            "WHERE st.schtag_name like %?1% AND sch_pub = 2 ORDER BY s.sch_start", nativeQuery = true)
    public List<Object[]> findSchedulesBySchTagName(String schTagName);


    @Query(value = "SELECT s.sch_id schId, s.sch_name schName, " +
            "s.mem_id memId, s.sch_start schStart, s.sch_end schEnd, " +
            "s.sch_pub schPub, s.sch_copy schCopy, s.sch_cost schCost, " +
            "st.schtag_id schTagId, st.schtag_name schTagName " +
            "FROM schedules s " +
            "JOIN schedule_tag_list stl ON s.sch_id = stl.sch_id " +
            "JOIN schedule_tag st ON stl.schtag_id = st.schtag_id " +
            "WHERE st.schtag_id = ?1 AND sch_pub = 2 ORDER BY s.sch_start", nativeQuery = true)
    public List<TestDTO> testDTO(Integer schTagId);
}
