package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.service.ScheduleManageService;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import java.util.List;

// 行程管理
@RestController("/schedules")
public class ScheduleManageController {

    @Autowired
    private ScheduleManageService manageService;

    @Autowired
    private ScheduleService service;

    // 查詢使用者自己所有建立過的行程清單
    @GetMapping("/my/{memId}")
    public List<Schedule> findByMemId(@PathVariable Integer memId) {
        return manageService.getAllByMemId(memId);
    }

    // 新增一筆行程(包含選擇出發及結束日期、目的地標籤、行程名稱)
    @PostMapping("/addOne")
    public String addSchedule(@RequestBody Schedule schedule) {
        return manageService.add(schedule);
    }

    // 查詢單一行程後，對行程內容進行修改 編輯/修改/刪除行程
    @PutMapping("/edit/{schId}")
    public void update(@PathVariable Integer schId,
                       @RequestBody Schedule schedule) {
        manageService.updateById(schId, schedule);
    }

    // 屏蔽一筆行程功能
    // 結果:網頁上沒有顯示資料，但成功將資料庫中行程公開權限改成私人檢視
    // 但輸入不存在的行程ID沒有報錯，頁面為全白
    @GetMapping("/hide/{schId}")
    ResponseEntity<?> hide(@PathVariable Integer schId) {
        try {
            service.hideById(schId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ScheduleNotFoundException(schId));
        }
    }
}
