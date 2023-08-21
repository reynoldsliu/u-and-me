package tw.idv.cha102.g7.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleTagDTO {

    private Integer schId;

    private String schName;

    private Integer memId;

    private Date schStart;

    private Date schEnd;

    private Byte schPub;

    private Boolean schCopy;

    private Integer schCost;

    private Integer schTagId;

    private String schTagName;

    public ScheduleTagDTO(Object[] objects) {
        this.schId = (Integer) objects[0];
        this.schName = (String) objects[1];
        this.memId = (Integer) objects[2];
        this.schStart = (Date) objects[3];
        this.schEnd = (Date) objects[4];
        this.schPub = (Byte) objects[5];
        this.schCopy = (Boolean) objects[6];
        this.schCost = (Integer) objects[7];
        this.schTagId = (Integer) objects[8];
        this.schTagName = (String) objects[9];
    }
}
