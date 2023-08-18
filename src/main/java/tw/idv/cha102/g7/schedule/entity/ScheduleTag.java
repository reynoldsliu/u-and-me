package tw.idv.cha102.g7.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule_tag")
public class ScheduleTag {

    @Id
    @Column(name = "schtag_id")
    private Integer schTagId;

    @Column(name = "schtag_name")
    private String schTagName;

//    // 多對多(行程標籤→行程)
    @ManyToMany
//    @JsonBackReference
    @JsonManagedReference
    @JoinTable(
            joinColumns = @JoinColumn(
                    referencedColumnName = "schtag_id",
                    name = "schtag_id"),
            name = "schedule_tag_list",
            inverseJoinColumns = @JoinColumn(
                    name = "sch_id",
                    referencedColumnName = "sch_id")
    )
    private List<Schedule> schedules;
}
