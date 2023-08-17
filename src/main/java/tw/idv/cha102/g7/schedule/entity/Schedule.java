package tw.idv.cha102.g7.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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
    private Integer schPub;

    @Column(name = "sch_copy")
    private Integer schCopy;

    @Column(name = "sch_cost")
    private Integer schCost;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sch_id", referencedColumnName = "sch_id")
    private List<ScheduleDetail> scheduleDetails;



    // 多對多(行程→行程標籤)
//    @ManyToMany(mappedBy = "schedules",
//                fetch = FetchType.EAGER)
//    private List<ScheduleTag> scheduleTags;

}
