package tw.idv.cha102.g7.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDetailDTO {

    private Integer schId;

    private String schName;

    private Integer memId;

    private Date schStart;

    private Date schEnd;

    private Byte schPub;

    private Boolean schCopy;

    private Integer schCost;

    private List<ScheduleDetail> scheduleDetails;

    public ScheduleDetailDTO(Object[] objects) {
        this.schId = (Integer) objects[0];
        this.schName = (String) objects[1];
        this.memId = (Integer) objects[2];
        this.schStart = (Date) objects[3];
        this.schEnd = (Date) objects[4];
        this.schPub = (Byte) objects[5];
        this.schCopy = (Boolean) objects[6];
        this.schCost = (Integer) objects[7];
        this.scheduleDetails = (List<ScheduleDetail>) objects[8];
    }
}
