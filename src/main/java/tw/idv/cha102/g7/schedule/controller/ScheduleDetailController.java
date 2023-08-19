package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;
import tw.idv.cha102.g7.schedule.service.impl.ScheduleDetailServiceImpl;

import java.util.List;

@RestController
public class ScheduleDetailController {

    @Autowired
    private ScheduleDetailServiceImpl service;

    @GetMapping("/schde/test/{schId}")
    public List<ScheduleDetail> findScheduleWithDetails(Integer schId){
        return service.findBySchId(schId);
    }

}
