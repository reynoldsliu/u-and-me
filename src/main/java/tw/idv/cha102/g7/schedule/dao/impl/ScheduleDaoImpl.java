package tw.idv.cha102.g7.schedule.dao.impl;

import com.example.demo.schedule.dao.ScheduleDao;
import com.example.demo.schedule.vo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 尚未改版
@Component
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String INSERT_STMT =

    private String GET_ALL_STMT =
            "SELECT * FROM schedules order by sch_id";
    private String GET_ONE_STMT =
            "SELECT sch_id,sch_name,mem_id,sch_start,sch_end,sch_pub,sch_copy,sch_cost FROM schedules where sch_id = ?";
    private String DELETE =
            "DELETE FROM schedules where sch_id = ?";
    private String

    @Override
    public void insert(Schedule schedule) {

        String sql = "INSERT INTO schedules (sch_id,sch_name,mem_id,sch_start,sch_end,sch_pub,sch_copy,sch_cost) VALUES (:schId, :schName, :memId, :schStart, :schEnd, :schPub, :schCopy, :schCost)";

        Map<String, Object> map = new HashMap<>();
        map.put("schId", schedule.getSchId());
        map.put("schName", schedule.getSchName());
        map.put("memId", schedule.getMemId());
        map.put("schStart", schedule.getSchStart());
        map.put("schEnd", schedule.getSchEnd());
        map.put("schPub", schedule.getSchPub());
        map.put("schCopy", schedule.getSchCopy());
        map.put("schCost", schedule.getSchCost());

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void updateById(Integer schId, Schedule schedule) {

        String sql = "UPDATE schedules set sch_name=:schName, mem_id=:memId, sch_start=:schStart, sch_end=:schEnd, sch_pub=:schPub, sch_copy=:schCopy, sch_cost=:schCost where sch_id = :schId";

        Map<String, Object> map = new HashMap<>();
        map.put("schId", schedule.getSchId());
        map.put("schName", schedule.getSchName());
        map.put("memId", schedule.getMemId());
        map.put("schStart", schedule.getSchStart());
        map.put("schEnd", schedule.getSchEnd());
        map.put("schPub", schedule.getSchPub());
        map.put("schCopy", schedule.getSchCopy());
        map.put("schCost", schedule.getSchCost());

        namedParameterJdbcTemplate.update(sql, map);
    }


    @Override
    public void deleteById(Integer schId) {




    }

    @Override
    public Schedule getById(Integer schId) {

        Schedule schedule = null;
        ResultSet rs = null;

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {

            Class.forName(driver);

            pstmt.setInt(1, schId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                // empVo 也稱為 Domain objects
                schedule = new Schedule();
                schedule.setSchId(rs.getInt("sch_id"));
                schedule.setSchName(rs.getString("sch_name"));
                schedule.setMemId(rs.getInt("mem_id"));
                schedule.setSchStart(rs.getDate("sch_start"));
                schedule.setSchEnd(rs.getDate("sch_end"));
                schedule.setSchPub(rs.getInt("sch_pub"));
                schedule.setSchCopy(rs.getInt("sch_copy"));
                schedule.setSchCost(rs.getInt("sch_cost"));
            }

            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
        }
        return schedule;
    }

    @Override
    public List<Schedule> getAll() {
        List<Schedule> list = new ArrayList<Schedule>();
        Schedule schedule = null;

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);
             ResultSet rs = pstmt.executeQuery()) {

            Class.forName(driver);

            while (rs.next()) {
                // empVO 也稱為 Domain objects
                schedule = new Schedule();
                schedule.setSchId(rs.getInt("sch_id"));
                schedule.setSchName(rs.getString("sch_name"));
                schedule.setMemId(rs.getInt("mem_id"));
                schedule.setSchStart(rs.getDate("sch_start"));
                schedule.setSchEnd(rs.getDate("sch_end"));
                schedule.setSchPub(rs.getInt("sch_pub"));
                schedule.setSchCopy(rs.getInt("sch_copy"));
                schedule.setSchCost(rs.getInt("sch_cost"));
                list.add(schedule); // Store the row in the list
            }

            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        }
        return list;
    }
}
