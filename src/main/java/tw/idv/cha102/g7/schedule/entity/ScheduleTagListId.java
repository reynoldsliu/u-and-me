package tw.idv.cha102.g7.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Embeddable
//@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "schedule_tag_list")
public class ScheduleTagListId implements Serializable {

//    @Column(name = "sch_id")
    private Integer schId;

//    @Column(name = "schtag_id")
    private Integer schTagId;


}
