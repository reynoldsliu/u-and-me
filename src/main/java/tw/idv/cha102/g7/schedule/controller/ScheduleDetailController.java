package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;
import tw.idv.cha102.g7.schedule.service.ScheduleService;
import tw.idv.cha102.g7.schedule.service.impl.ScheduleDetailServiceImpl;

import java.util.List;

// 查看行程詳情
@RestController
public class ScheduleDetailController {

    @Autowired
    private ScheduleService service;

    @Autowired
    private ScheduleDetailServiceImpl detailService;

    @GetMapping("/schde/test/{schId}")
    public List<ScheduleDetail> findScheduleWithDetails(Integer schId){
        return detailService.findBySchId(schId);
    }

}
