package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.service.ScheduleReportService;

@RestController
@RequestMapping("/schedules/report")
public class ScheduleReportController {

    @Autowired
    private ScheduleReportService service;

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
