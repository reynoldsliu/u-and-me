package tw.idv.cha102.g7.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagToSchedulesDTO {

    private ScheduleTag tag;

    private List<Schedule> schedules;

//    private Integer schTagId;
//
//    private String schTagName;
//
//    private Integer schId;
//
//    private String schName;
//
//    private Integer memId;
//
//    private Date schStart;
//
//    private Date schEnd;
//
//    private Byte schPub;
//
//    private Boolean schCopy;
//
//    private Integer schCost;


    public TagToSchedulesDTO(Object[] objects) {
        this.tag = (ScheduleTag) objects[0];
        this.schedules = (List<Schedule>) objects[1];
//        this.schTagId = (Integer) objects[0];
//        this.schTagName = (String) objects[1];
//        this.schId = (Integer) objects[2];
//        this.schName = (String) objects[3];
//        this.memId = (Integer) objects[4];
//        this.schStart = (Date) objects[5];
//        this.schEnd = (Date) objects[6];
//        this.schPub = (Byte) objects[7];
//        this.schCopy = (Boolean) objects[8];
//        this.schCost = (Integer) objects[9];
    }
}
