package tw.idv.cha102.g7.schedule.service;

import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;

import java.util.List;

public interface ScheduleDetailService {
    public List<ScheduleDetail> findBySchId(Integer schId);
}
