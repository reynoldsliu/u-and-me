package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;
import tw.idv.cha102.g7.schedule.repo.ScheduleDetailRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleDetailService;

import java.util.List;

@Component
public class ScheduleDetailServiceImpl implements ScheduleDetailService {

    @Autowired
    ScheduleDetailRepository repository;

    @Override
    public List<ScheduleDetail> findBySchId(Integer schId) {
        return repository.findBySchId(schId);
    }
}
