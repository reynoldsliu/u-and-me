package tw.idv.cha102.g7.activity.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity_schedule_recommendation")
public class ActivitySchRecommen {

    @Id
    @Column(name = "sch_id")
    private Integer schId;

    @Column(name = "activ_id")
    private Integer activId;

}
