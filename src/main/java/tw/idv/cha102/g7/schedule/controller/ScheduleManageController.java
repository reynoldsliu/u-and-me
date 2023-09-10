package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/mySch")
public class ScheduleManageController {

    @Autowired
    private ScheduleService service;

    // 查詢使用者自己所有建立過的行程清單
    @GetMapping("/my/{memId}/{page}")
    public ResponseEntity<List<Schedule>> findByMemId(@PathVariable Integer memId,
                                                      @PathVariable int page) {
        List<Schedule> mySchedules = service.getAllByMemId(memId, page)
                .collect(Collectors.toList());
        return new ResponseEntity(mySchedules, HttpStatus.OK);
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


    /**
     * 會員
     * 刪除一個行程
     * @param schId 行程id
     * @return 刪除成功或失敗
     */
    @RequestMapping("/delete/{schId}")
    public ResponseEntity<?> delete(@PathVariable Integer schId) {
        try {
            String deleteMsg = service.deleteOneSchedule(schId);
            return new ResponseEntity(deleteMsg, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 對單一行程大綱內容進行修改
    @RequestMapping("/edit/{schId}")
    public ResponseEntity<?> edit(@PathVariable Integer schId,
                                  @RequestBody Schedule schedule) {
        try {
            service.edit(schId, schedule);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    // 屏蔽一筆行程
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

    /**
     * 會員
     * 公開行程權限設定
     * @param schId 行程id
     * @param schPub 公開權限
     * 0: 私密,
     * 1: 透過連結分寫,
     * 2: 公開,
     * @return 行程物件
     */
    @RequestMapping("/private/{schId}/{schPub}")
    public ResponseEntity<?> privateSelect(@PathVariable Integer schId,
                                           @PathVariable Byte schPub) {
        return ResponseEntity.ok(service.privateSelect(schId, schPub));

    }

    /**
     * 會員
     * 複製行程權限設定
     * @param schId 行程id
     * @param schCopy 複製權限
     * true: 可複製,
     * false: 不可複製,
     * @return 行程物件
     */
    @RequestMapping("/copyright/{schId}/{schCopy}")
    public ResponseEntity<?> copyrightSelect(@PathVariable Integer schId,
                                           @PathVariable Boolean schCopy) {
        return ResponseEntity.ok(service.copyrightSelect(schId, schCopy));

    }

}
