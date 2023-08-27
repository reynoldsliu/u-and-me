package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagList;
import tw.idv.cha102.g7.schedule.dto.TagsInScheduleDTO;
import tw.idv.cha102.g7.schedule.dto.TagToSchedulesDTO;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleTagListRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleTagRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleTagServiceImpl implements ScheduleTagService {

    @Autowired
    private ScheduleTagRepository tagRepository;

    @Autowired
    private ScheduleTagListRepository listRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

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
    public TagToSchedulesDTO findSchedulesBySchTagId(Integer schTagId) {
        ScheduleTag tag = tagRepository.findById(schTagId).orElse(null);
        List<ScheduleTagList> dtoList = listRepository.findAll();
        List<ScheduleTagList> schIdList = new ArrayList<>();
        List<Schedule> schList = new ArrayList<>();
        Schedule schedule = null;
        for (ScheduleTagList dto : dtoList) {
            if (dto.getScheduleTagListId().getSchTagId() == schTagId) {
                schIdList.add(dto);
                for (ScheduleTagList dto2 : schIdList) {
                    schedule = scheduleRepository.findById(dto2.getScheduleTagListId().getSchId()).orElse(null);
                    if (!schList.contains(schedule) && schedule != null) {
                        if (schedule.getSchPub() == 2)
                        schList.add(schedule);
                    }
                }
            }
        }
        schList = schList.stream().sorted(Comparator.comparing(Schedule::getSchStart)).collect(Collectors.toList());
        Object[] object = {tag, schList};
        TagToSchedulesDTO schedulesDTO = new TagToSchedulesDTO(object);
        return schedulesDTO;

        // 原先使用TagToSchedulesDTO時，其實體變數一一列出，不用List及物件包住
//        List<Object[]> list = tagRepository.findSchedulesBySchTagId(schTagId);
//        List<TagToSchedulesDTO> collect = list.stream().map(TagToSchedulesDTO::new).collect(Collectors.toList());
//        return collect;
    }

    // 待改寫
    @Override
    public List<TagToSchedulesDTO> findSchedulesBySchTagName(String schTagName) {
        List<ScheduleTag> tags = tagRepository.findBySchTagNameContaining(schTagName);

//        List<ScheduleTagListId>
        // 原先使用TagToSchedulesDTO時，其實體變數一一列出，不用List及物件包住
        List<Object[]> list = tagRepository.findSchedulesBySchTagName(schTagName);
        List<TagToSchedulesDTO> collect = list.stream().map(TagToSchedulesDTO::new).collect(Collectors.toList());
        return collect;
    }


    @Override
    public TagsInScheduleDTO findTagsBySchId(Integer schId) {
        Schedule schedule = scheduleRepository.findById(schId).orElse(null);
        List<ScheduleTagList> stList = listRepository.findAll();
        List<ScheduleTag> tagList = new ArrayList<>();
        ScheduleTag tag = null;
        for (ScheduleTagList stl : stList) {
            if (stl.getScheduleTagListId().getSchId() != schId) {
                // 將不符合schId的元素從stList中移除
                stList.remove(stl);
                for (ScheduleTagList stl2 : stList) {
                    // 將stList的每個元素一一取出，用tagId查詢到對應的ScheduleTag物件加入tagList中
                    tag = tagRepository.findById(stl2.getScheduleTagListId().getSchTagId()).orElse(null);
                    // 若此ScheduleTag物件不存在於tagList才可加入
                    if (!tagList.contains(tag))
                        tagList.add(tag);
                }

            }
        }
        Object[] object = {schedule, tagList};
        TagsInScheduleDTO tagsDTO = new TagsInScheduleDTO(object);
        return tagsDTO;
    }


}
