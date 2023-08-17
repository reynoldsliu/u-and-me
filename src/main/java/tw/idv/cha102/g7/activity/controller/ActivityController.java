package tw.idv.cha102.g7.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.activity.entity.Activity;
import tw.idv.cha102.g7.activity.service.ActivityService;
import tw.idv.cha102.g7.schedule.entity.Schedule;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/activity/{activId}")
    public Activity read(@PathVariable Integer activId) {
        return activityService.getById(activId);
    }

    @GetMapping("/name={activName}")
    public List<Activity> findByActivName(@PathVariable String activName) {
        return activityService.findByActivName(activName);
    }

    @GetMapping("/name2={activCon}")
    public List<Activity> findByActivCon(@PathVariable String activCon) {
        return activityService.findByActivCon(activCon);

        // 想做查無資料會回傳查無此活動
    }
}
