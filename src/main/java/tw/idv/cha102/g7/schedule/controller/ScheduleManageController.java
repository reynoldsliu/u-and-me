package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import java.util.List;

// 行程管理
@RestController
@RequestMapping("/schedules")
public class ScheduleManageController {

    @Autowired
    private ScheduleService service;

    // 查詢使用者自己所有建立過的行程清單
    @GetMapping("/my/{memId}")
    public List<Schedule> findByMemId(@PathVariable Integer memId) {
        return service.getAllByMemId(memId);
    }

    // 新增一筆行程(包含選擇出發及結束日期、目的地標籤、行程名稱)
    // 可以新增，但若資料庫中有相同id的行程，資料會被覆蓋過去
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Schedule schedule) {
        try {
            service.create(schedule);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // 刪除一筆行程
    @DeleteMapping("/delete/{schId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer schId) {
        try {
            service.delete(schId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    // 查詢單一行程(行程概要)後，對行程內容進行修改
    // 修改行程公開權限(私密、透過連結分享、公開)
    // 行程共同編輯成員及權限設定(可檢視、可編輯、新增及移除共編成員，透過連結分享邀請成員共編)
    @PutMapping("/edit/{schId}")
    public ResponseEntity<?> edit(@PathVariable Integer schId,
                                  @RequestBody Schedule schedule) {
        try {
            service.edit(schId, schedule);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ScheduleNotFoundException(schId));
        }
    }

    // 屏蔽一筆行程功能
    // 結果:網頁上沒有顯示資料，但成功將資料庫中行程公開權限改成私人檢視
    // 但輸入不存在的行程ID沒有報錯，頁面為全白
    @GetMapping("/hide/{schId}")
    public ResponseEntity<?> hide(@PathVariable Integer schId) {
        try {
            service.hide(schId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ScheduleNotFoundException(schId));
        }
    }
}
