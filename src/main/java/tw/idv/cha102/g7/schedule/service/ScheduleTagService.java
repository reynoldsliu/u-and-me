package tw.idv.cha102.g7.schedule.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagDTO;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.entity.TestDTO;

import java.util.List;

public interface ScheduleTagService {

    // 查詢所有標籤
    public List<ScheduleTag> findAll();

    // 依照標籤id查詢對應標籤
    public ScheduleTag findById(Integer schTagId);

    // 依照標籤名稱查詢對應標籤
    public List<ScheduleTag> findByName(String schTagName);

    // 依照標籤id查詢對應行程
    public List<ScheduleTagDTO> findSchedulesBySchTagId(Integer schTagId);

    // 依照標籤名稱查詢對應行程
    public List<ScheduleTagDTO> findSchedulesBySchTagName(String schTagName);

    public List<TestDTO> test(Integer schTagId);
}
