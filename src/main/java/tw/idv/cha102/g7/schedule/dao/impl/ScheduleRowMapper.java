package tw.idv.cha102.g7.schedule.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import tw.idv.cha102.g7.schedule.vo.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleRowMapper implements RowMapper<Schedule> {
    @Override
    public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setSchId(rs.getInt("sch_id"));
        schedule.setSchName(rs.getString("sch_name"));
        schedule.setMemId(rs.getInt("mem_id"));
        schedule.setSchStart(rs.getDate("sch_start"));
        schedule.setSchEnd(rs.getDate("sch_end"));
        schedule.setSchPub(rs.getInt("sch_pub"));
        schedule.setSchPub(rs.getInt("sch_copy"));
        schedule.setSchPub(rs.getInt("sch_cost"));

        return schedule;
    }
}
