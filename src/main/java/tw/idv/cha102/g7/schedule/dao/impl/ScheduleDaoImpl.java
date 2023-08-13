package tw.idv.cha102.g7.schedule.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.dao.ScheduleDao;
import tw.idv.cha102.g7.schedule.dao.ScheduleRepository;
import tw.idv.cha102.g7.schedule.vo.Schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ScheduleDaoImpl implements ScheduleDao{

//    @Autowired
//    private ScheduleRepository repository;
//
//    public List<Schedule> getAll() {
//
//        List<Schedule> schedules = repository.findAll();
//        return schedules;



//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



//    private String GET_ONE_STMT =
//            "SELECT sch_id,sch_name,mem_id,sch_start,sch_end,sch_pub,sch_copy,sch_cost FROM schedules where sch_id = ?";
//
//
//    @Override
//    public void insert(Schedule schedule) {
//
//        String sql = "INSERT INTO schedules (sch_id,sch_name,mem_id,sch_start,sch_end,sch_pub,sch_copy,sch_cost) VALUES (:schId, :schName, :memId, :schStart, :schEnd, :schPub, :schCopy, :schCost)";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("schId", schedule.getSchId());
//        map.put("schName", schedule.getSchName());
//        map.put("memId", schedule.getMemId());
//        map.put("schStart", schedule.getSchStart());
//        map.put("schEnd", schedule.getSchEnd());
//        map.put("schPub", schedule.getSchPub());
//        map.put("schCopy", schedule.getSchCopy());
//        map.put("schCost", schedule.getSchCost());
//
//        namedParameterJdbcTemplate.update(sql, map);
//
//    }
//
//    @Override
//    public void updateById(Integer schId, Schedule schedule) {
//
//        String sql = "UPDATE schedules set sch_name=:schName, mem_id=:memId, sch_start=:schStart, sch_end=:schEnd, sch_pub=:schPub, sch_copy=:schCopy, sch_cost=:schCost where sch_id = :schId";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("schId", schedule.getSchId());
//        map.put("schName", schedule.getSchName());
//        map.put("memId", schedule.getMemId());
//        map.put("schStart", schedule.getSchStart());
//        map.put("schEnd", schedule.getSchEnd());
//        map.put("schPub", schedule.getSchPub());
//        map.put("schCopy", schedule.getSchCopy());
//        map.put("schCost", schedule.getSchCost());
//
//        namedParameterJdbcTemplate.update(sql, map);
//    }
//
//
//    @Override
//    public void deleteById(Integer schId) {
//        String sql = "DELETE FROM schedules where sch_id = :schId";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("schId", schId);
//
//        namedParameterJdbcTemplate.update(sql, map);
//
//    }
//
//    @Override
//    public Schedule getById(Integer schId) {
//
//        String sql = "SELECT sch_id,sch_name,mem_id,sch_start,sch_end,sch_pub,sch_copy,sch_cost FROM schedules WHERE sch_id = :schId order by sch_id";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("schId", schId);
//
//        List<Schedule> list = namedParameterJdbcTemplate.query(sql, map, new ScheduleRowMapper());
//
//        // 表示這個list裡面有數據
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            // 解決 index out of bound 問題
//            return null;
//        }
//    }
//
//
//    }
}
