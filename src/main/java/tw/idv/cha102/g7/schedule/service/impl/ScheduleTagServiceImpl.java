package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.dto.ScheduleTagListDTO;
import tw.idv.cha102.g7.schedule.dto.ScheduleToTagsDTO;
import tw.idv.cha102.g7.schedule.dto.TagToSchedulesDTO;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleTagListRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleTagRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleTagServiceImpl implements ScheduleTagService {

    @Autowired
    private ScheduleTagRepository tagRepository;

    @Autowired
    private ScheduleTagListRepository listRepository;

    @Autowired
    ScheduleRepository repository;

    @Override
    public List<ScheduleTag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public ScheduleTag findById(Integer schTagId) {
        ScheduleTag scheduleTag = tagRepository.findById(schTagId).orElse(null);
        return scheduleTag;
    }

    @Override
    public List<ScheduleTag> findByName(String schTagName) {
        return tagRepository.findBySchTagNameContaining(schTagName);
    }


    @Override
    public List<TagToSchedulesDTO> findSchedulesBySchTagId(Integer schTagId) {
        List<Object[]> list = tagRepository.findSchedulesBySchTagId(schTagId);
        List<TagToSchedulesDTO> collect = list.stream().map(TagToSchedulesDTO::new).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<TagToSchedulesDTO> findSchedulesBySchTagName(String schTagName) {
        List<Object[]> list = tagRepository.findSchedulesBySchTagName(schTagName);
        List<TagToSchedulesDTO> collect = list.stream().map(TagToSchedulesDTO::new).collect(Collectors.toList());
        return collect;
    }

    @Override
    public ScheduleToTagsDTO findTagsBySchId(Integer schId) {
        Schedule schedule = repository.findById(schId).orElse(null);
        List<ScheduleTagListDTO> dtoList = listRepository.findAll();
        List<ScheduleTagListDTO> tagIdList = new ArrayList<>();
        List<ScheduleTag> tagList = new ArrayList<>();
        ScheduleTag tag = null;
        for (ScheduleTagListDTO dto : dtoList) {
            if (dto.getScheduleTagListId().getSchId() == schId) {
                // 拿取schId對應到的tagId加入tagIdList中
                tagIdList.add(dto);
                for (ScheduleTagListDTO dto2 : tagIdList) {
                    // 將tagId對應到的ScheduleTag物件加入tagList中
                    tag = tagRepository.findById(dto2.getScheduleTagListId().getSchTagId()).orElse(null);
                    // 若此ScheduleTag物件不存在於tagList才可加入
                    if(!tagList.contains(tag))
                    tagList.add(tag);
                }

            }
        }
        Object[] object = {schedule, tagList};
        ScheduleToTagsDTO tagsDTO = new ScheduleToTagsDTO(object);
        return tagsDTO;
    }




}
