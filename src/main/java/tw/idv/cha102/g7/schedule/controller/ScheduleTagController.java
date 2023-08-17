package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.List;

@RestController
public class ScheduleTagController {

    @Autowired
    private ScheduleTagService service;

    @GetMapping("/schTag")
    public List<ScheduleTag> finaAllTag(){
        return service.findAll();
    }

    @GetMapping("/schTag/id/{schTagId}")
    public ScheduleTag findById(@PathVariable Integer schTagId){
        return service.findById(schTagId);
    }

    @GetMapping("/schTag/name/{schTagName}")
    public List<ScheduleTag> findByName(@PathVariable String schTagName){
        return service.findByName(schTagName);
    }

}
