package tw.idv.cha102.g7.schedule.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedules")
public class Schedule {
    @Id
    @Column(name = "sch_id")
    private Integer schId;

    @Column(name = "sch_name")
    private String schName;

    @Column(name = "mem_id")
    private Integer memId;

    @Column(name = "sch_start")
    private Date schStart;

    @Column(name = "sch_end")
    private Date schEnd;

    @Column(name = "sch_pub")
    @JsonProperty("schPub")
    private Byte schPub;

    @Column(name = "sch_copy")
    private Boolean schCopy;

    @Column(name = "sch_cost")
    private Integer schCost;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "sch_id", referencedColumnName = "sch_id")
//    private List<ScheduleDetail> scheduleDetails;

}
