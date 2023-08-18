package tw.idv.cha102.g7.schedule.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagDTO;
import tw.idv.cha102.g7.schedule.entity.TestDTO;
import tw.idv.cha102.g7.schedule.repo.ScheduleTagRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<TestDTO> test(Integer schTagId) {
        return repository.testDTO(schTagId);
    }

    @Override
    public List<ScheduleTagDTO> findSchedulesBySchTagId(Integer schTagId) {
        List<Object[]> list =  repository.findSchedulesBySchTagId(schTagId);
        List<ScheduleTagDTO> collect = list.stream().map(ScheduleTagDTO::new).collect(Collectors.toList());
        return collect;
    }

    public List<ScheduleTagDTO> findSchedulesBySchTagName(String schTagName){
        List<Object[]> list = repository.findSchedulesBySchTagName(schTagName);
        List<ScheduleTagDTO> collect = list.stream().map(ScheduleTagDTO::new).collect(Collectors.toList());
        return collect;
    }

}
