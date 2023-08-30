package tw.idv.cha102.g7.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.activity.entity.Activity;
import tw.idv.cha102.g7.activity.service.ActivityService;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.entity.Schedule;


import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    // 依照活動Id，查詢活動
    @GetMapping("/activity/{activId}")
    public Activity getbyId(@PathVariable Integer activId) {
        return activityService.getById(activId);
    }

    // 依照活動名稱關鍵字，查詢所有在架上活動清單
    @GetMapping("/name/{activName}")
    public List<Activity> findByActivName(@PathVariable String activName) {
        return activityService.findByActivName(activName);
    }

    // 依照活動內容關鍵字，查詢所有在架上活動清單
    @GetMapping("/name2/{activCon}")
    public List<Activity> findByActivCon(@PathVariable String activCon) {
        return activityService.findByActivCon(activCon);

        // 做查無資料會回傳查無此活動
    }

    // 管理員新增活動
    @PostMapping("/addactivity")
    public String insert(@RequestBody Activity activity) {
        activityService.insert(activity);
        return "Create成功";
    }

    // 管理員刪除活動
    @DeleteMapping("/delete/{activId}")
    public String delete(@PathVariable Integer activId) {
        activityService.deleteById(activId);
        return "Delete成功";
    }

    // 管理員修改活動(包含上、下架狀態)
//    @PutMapping("/update/{activId}")
//    public String update(@PathVariable Integer activId,
//                         @RequestBody Activity activity) {
//        activityService.updateById(activId, activity);
//        return "Update成功";
//    }

    @PutMapping("/update/{activId}")
    public ResponseEntity<?> edit(@PathVariable Integer activId,
                                  @RequestBody Activity activity) {
        Activity existingActivity = activityService.getById(activId);

        if (existingActivity != null) {

            // 更新現有資料
            existingActivity.setActivPic(activity.getActivPic());
            existingActivity.setActivName(activity.getActivName());
            existingActivity.setActivCon(activity.gettActivCon());
//            existingActivity.setActivEndtime(activity.getActivEndtime());
            existingActivity.setActivSta(activity.getActivSta());
            // 保存
            activityService.updateById(activId, existingActivity);
            return ResponseEntity.ok().build();
        } else {
            return null;
        }
    }

    // 查全部活動
    @GetMapping("/activityall")
    public List<Activity> findAllActivity() {
        List<Activity> activityList = activityService.findAllActivity();
        return activityList;
    }


    // -------------------- 待辦 ------------------

//    @GetMapping("/activityall")
//    List<Activity> all() {
//        List<Activity> list = activityService.findAllActivity();
//
//        for (Activity activity : list) {
//            System.out.println(activity);
//        }
//        return list;
//    }


    // 隨機  加?count=3
    @GetMapping("/activityrandom")
    public List<Activity> getRandomActivity(@RequestParam int count) {
        return activityService.getRandomActivity(count);
    }

}
