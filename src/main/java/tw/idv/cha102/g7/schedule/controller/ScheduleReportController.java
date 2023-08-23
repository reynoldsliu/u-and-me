package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleReport;
import tw.idv.cha102.g7.schedule.service.ScheduleReportService;

import java.util.List;

@RestController
@RequestMapping("/schedules/report")
public class ScheduleReportController {

    @Autowired
    private ScheduleReportService reportService;

    // 查詢所有被檢舉行程清單
    @GetMapping("/getAll")
    public List<ScheduleReport> getAll(){
        List<ScheduleReport> list = reportService.findAll();
        return list;
    }

    // 查看行程詳情


    // 屏蔽一筆行程功能
    // 結果:網頁上沒有顯示資料，但成功將資料庫中行程公開權限改成私人檢視
    // 但輸入不存在的行程ID沒有報錯，頁面為全白
    @GetMapping("/hide/{schId}")
    public ResponseEntity<?> hide(@PathVariable Integer schId) {
        try {
            reportService.hideById(schId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ScheduleNotFoundException(schId));
        }
    }

    @GetMapping("/delete/{schId}")
    public ResponseEntity<?> delete(@PathVariable Integer schId){
        try {
            String str = reportService.deleteReportedSchedule(schId);
            return ResponseEntity.ok(str);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ScheduleNotFoundException(schId));
        }
    }

    @PostMapping("/status")
    public ResponseEntity<?> modify(@RequestBody ScheduleReport report){
        try {
            String str = reportService.modifyReportStatus(report);
            return ResponseEntity.ok(str);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }


}
