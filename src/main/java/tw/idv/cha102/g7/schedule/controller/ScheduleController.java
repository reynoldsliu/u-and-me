package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService service;



    // 查詢所有公開行程清單，並依照日期排序
    @GetMapping("/public")
    public List<Schedule> findAllPublic() {
        return service.findAllPublic();
    }

    // 依照行程名稱，查詢所有公開行程清單，並依照起始日期排序
    @GetMapping("/name/{schName}")
    public List<Schedule> findBySchName(@PathVariable String schName) {
        return service.findBySchName(schName);
    }

    // 依照行程開始日期及結束日期，查詢所有期限內的公開行程清單，並依照起始日期排序
    @RequestMapping(value = "/datebetween", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Schedule> findBetweenDate(@RequestBody @PathVariable Schedule schedule) {
        List<Schedule> schedules = service.findBetweenDate(schedule.getSchStart(), schedule.getSchEnd());
        return schedules;
    }

    // 查詢使用者自己所有建立過的行程清單
    @GetMapping("/memId/{memId}")
    public List<Schedule> getAllByMemId(@PathVariable Integer memId) {
        return service.getAllByMemId(memId);
    }

    // 依行程ID，查詢單一行程內容
    @GetMapping("/schId/{schId}")
    public Schedule getOne(@PathVariable Integer schId) {
        return service.getById(schId);
    }

    // 新增一筆行程
    // 可以新增，但若資料庫中有相同id的行程，資料會被覆蓋過去
    @PostMapping("/add")
    ResponseEntity<?> insert(@RequestBody Schedule schedule) {
        try {
            service.add(schedule);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // 對單一行程內容進行修改
    @PutMapping("/{schId}")
    public void update(@PathVariable Integer schId,
                       @RequestBody Schedule schedule) {
        service.updateById(schId, schedule);
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

    @DeleteMapping("/delete/{schId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer schId) {
        try {
            service.deleteById(schId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/test123/{schId}")
    public ResponseEntity<?> getOneScheDetail(@PathVariable Integer schId) {
        try {
//            service.getById(schId);
            return ResponseEntity.ok(service.getOneById(schId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ScheduleNotFoundException(schId));
        }
    }



    // ======================== 以上均經過測試且結果成功 ========================
    // ==================== 以下為經過測試且結果失敗，待查原因 ====================

    // 測試網頁可以跳轉到設定的路徑，但經過html送出資料後，xhr資料無法抓到資料進入對應的jsp檔案路徑
    @GetMapping("/test")
    public void select(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/jsp/GetJson_FromDb.html";

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 getAllSche.jsp
        successView.forward(req, res);
    }

    // 測試寫法1:老師建議的寫法，待了解結構及測試，只有回傳jsp路徑，沒有導向其他網頁
    @RequestMapping("/getAllSchedules")
    public String getAllSchedules(Model model) {
        List<Schedule> schedule = service.getAll();
        model.addAttribute("schedules", schedule);
        return "/jsp/getAllSche.jsp";
    }

    // 測試寫法2: 原始寫法，可以跳轉網頁，但路徑設定似乎有誤
    @RequestMapping("/getAllSchedules2")
    public void getAllSche(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/jsp/getAllSche.jsp";

        List<Schedule> schedules = service.getAll();
        req.setAttribute("schedules", schedules);

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }


    // ======================== 待測試 ========================

//    @GetMapping("/schedules/{schId}")
//    ResponseEntity<?> getById(@PathVariable Integer schId) {
//        var schedule = service.getById(schId);
//        if(schedule != null){
//            service.getById(schId);
//        }else {
//            throw new ScheduleNotFoundException(schId);
//        }
//    }


}
