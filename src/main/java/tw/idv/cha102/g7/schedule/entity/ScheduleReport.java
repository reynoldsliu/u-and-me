package tw.idv.cha102.g7.schedule.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "schedule_rep")
public class ScheduleReport {

    @Id
    @Column(name = "schrep_id")
    private Integer schRepId;

    @Column(name = "mem_id")
    private Integer memId;

    @Column(name = "sch_id")
    private Integer schId;

    @Column(name = "schrep_con")
    private String schRepCon;

    @Column(name = "host_id")
    private Integer hostId;

    @Column(name = "schrep_sta")
    private Integer schRepSta;
}
