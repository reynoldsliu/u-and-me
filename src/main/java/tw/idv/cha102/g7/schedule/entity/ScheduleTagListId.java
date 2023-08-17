package tw.idv.cha102.g7.schedule.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ScheduleTagListId implements Serializable {

    private Integer schId;
    private Integer schTagId;

    public ScheduleTagListId(Integer schId, Integer schTagId) {
        this.schId = schId;
        this.schTagId = schTagId;
    }

}
