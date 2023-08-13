package tw.idv.cha102.g7.schedule.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "schedule_tag")
public class ScheduleTag {

    @Id
    @Column(name = "schtag_id")
    private Integer schTagId;

    @Column(name = "schtag_name")
    private String schTagName;
}
