package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.schedule.dto.TagsInScheduleDTO;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.dto.TagToSchedulesDTO;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.List;

@RestController
@RequestMapping("/schedules/schTag")
public class ScheduleTagController {

    @Autowired
    private ScheduleTagService service;

    @GetMapping("/")
    public List<ScheduleTag> finaAllTag() {
        return service.findAll();
    }

    @GetMapping("/id/{schTagId}")
    public ScheduleTag findById(@PathVariable Integer schTagId) {
        return service.findById(schTagId);
    }

    @GetMapping("/name/{schTagName}")
    public List<ScheduleTag> findByName(@PathVariable String schTagName) {
        return service.findByName(schTagName);
    }

    @GetMapping("/DTOid/{schTagId}")
    public TagToSchedulesDTO findSchedules(@PathVariable Integer schTagId){
        return service.findSchedulesBySchTagId(schTagId);
    }

    // 藉由行程標籤名字找出對應行程(待改寫)
    @GetMapping("/DTOname/{schTagName}")
    public List<TagToSchedulesDTO> findSchedulesByTagName(@PathVariable String schTagName){
        return service.findSchedulesBySchTagName(schTagName);
    }

    // 藉由行程id找出對應行程標籤
    @GetMapping("/schId/{schId}")
    public TagsInScheduleDTO findTagsBySchId(@PathVariable Integer schId){
        return service.findTagsBySchId(schId);
    }


}
