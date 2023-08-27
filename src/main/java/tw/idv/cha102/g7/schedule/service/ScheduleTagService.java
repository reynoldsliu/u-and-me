package tw.idv.cha102.g7.schedule.service;

import tw.idv.cha102.g7.schedule.dto.TagsInScheduleDTO;
import tw.idv.cha102.g7.schedule.dto.TagToSchedulesDTO;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;

import java.util.List;

public interface ScheduleTagService {

    // 查詢所有標籤
    public List<ScheduleTag> findAll();

    // 依照標籤id查詢對應標籤
    public ScheduleTag findById(Integer schTagId);

    // 依照標籤名稱查詢對應標籤
    public List<ScheduleTag> findByName(String schTagName);

    // 依照標籤id查詢對應行程
    public TagToSchedulesDTO findSchedulesBySchTagId(Integer schTagId);

    // 依照標籤名稱查詢對應行程
    public List<TagToSchedulesDTO> findSchedulesBySchTagName(String schTagName);

    // 依照行程id查詢對應標籤
    public TagsInScheduleDTO findTagsBySchId(Integer schId);

}
