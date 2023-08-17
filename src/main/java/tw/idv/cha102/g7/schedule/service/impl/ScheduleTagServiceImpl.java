package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.repo.ScheduleTagRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.List;

@Component
public class ScheduleTagServiceImpl implements ScheduleTagService {

    @Autowired
    private ScheduleTagRepository repository;

    @Override
    public List<ScheduleTag> findAll() {
        return repository.findAll();
    }

    @Override
    public ScheduleTag findById(Integer schTagId) {
        ScheduleTag scheduleTag = repository.findById(schTagId).orElse(null);
        return scheduleTag;
    }

    @Override
    public List<ScheduleTag> findByName(String schTagName) {
        return repository.findBySchTagNameContaining(schTagName);
    }
}
