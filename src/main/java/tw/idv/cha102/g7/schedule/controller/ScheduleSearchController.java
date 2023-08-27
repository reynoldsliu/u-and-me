package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.schedule.dto.ScheduleDayDTO;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import java.sql.Date;
import java.util.List;

// 瀏覽公開行程
@RestController
@RequestMapping("/schedules")
public class ScheduleSearchController {

    @Autowired
    private ScheduleService service;

    /**
     * 一般使用者
     * 查詢所有最新公開行程並依分頁顯示
     * @param page 當前分頁 (從0開始)(暫定顯示每頁9筆行程)
     * @return 返回所有公開行程列表
     */
    @GetMapping("/all/{page}")
    public List<Schedule> findAllPublic(@PathVariable Integer page){
        return service.getAllPaged(page,9);
    }

    /**
     * 一般使用者
     * 以行程名稱查詢行程
     * @param keyword 欲查詢的名稱
     * @return 返回查詢結果
     */
    @GetMapping("/{keyword}")
    public List<Schedule> findBySchName(@PathVariable String keyword) {
        return service.findBySchName(keyword);
    }

    /**
     * 一般使用者
     * 以行程開始日期及結束日期，查詢期限內的行程
     * @param schStart 行程開始日期
     * @param schEnd 行程結束日期
     * @return 返回查詢結果
     */
    @GetMapping(value = "/dateBetween/{schStart}/{schEnd}")
    public List<Schedule> findBetweenDate(@PathVariable Date schStart,
                                          @PathVariable Date schEnd) {
        List<Schedule> schedules = service.findBetweenDate(schStart, schEnd);
        return schedules;
    }

    /**
     * 一般使用者
     * 以行程天數由小到大排序，查詢行程(查詢結果，物件屬性沒有經過排序，待修正)
     * @return 返回查詢結果
     */
    @GetMapping(value = "/days")
    public  List<ScheduleDayDTO> findByDays(){
        List<ScheduleDayDTO> schedules = service.findByDays();
        return schedules;
    }

    /**
     * 一般使用者
     * 以行程預估消費範圍由小到大排序，查詢行程(查詢結果，物件屬性沒有經過排序，待修正)
     * @return 返回查詢結果
     */



    /**
     * 一般使用者(暫時不會用到)
     * 查詢單一行程(依據行程ID)(若輸入不存在的id，甚麼都不會出現)
     * @return 返回查詢結果
     */
    @GetMapping("/schId/{schId}")
    public Schedule getOne(@PathVariable Integer schId) {
        return service.getById(schId);
    }





    // 查詢行程及其細節，並依照行程細節起始時間排序(若輸入不存在的id，會404)
    // @OneToMany的Join寫法
//    @GetMapping("/one/{schId}")
//    public ResponseEntity<?> getOneScheDetail(@PathVariable Integer schId) {
//        try {
//            Schedule schedule = service.getOneById(schId);
//
//            List<ScheduleTagDTO> scheduleTagDTOS = service.findTagsInOneSchdule(schId);
//            List<ScheduleDetail> scheduleDetails = service.getOneById(schId).getScheduleDetails();
//            List<String> tagNames = new ArrayList<>();
//            List<Object> returnList = new ArrayList<>();
//            returnList.add(schedule);
//            for(ScheduleDetail scheduleDetail:scheduleDetails){
//                returnList.add(scheduleDetail);
//            }
//            for(ScheduleTagDTO dto:scheduleTagDTOS){
//                if(dto.getSchTagName() != null){
//                    returnList.add(dto.getSchTagName());
//                }
//            }
//            return ResponseEntity.ok(returnList);
//        } catch (Exception e) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body(new ScheduleNotFoundException(schId));
//        }
//    }

    // 從單一行程中查詢對應標籤(但是有重複單一行程資料的問題)、若輸入不存在id的資料為[]
//    @GetMapping("/tags/{schId}")
//    public ResponseEntity<?> getTagsByOneSchedule(@PathVariable Integer schId){
//        try {
//            List<TagToSchedulesDTO> scheduleTagDTOS = service.findTagsInOneSchdule(schId);
//            List<String> tagNames = new ArrayList<>();
//            for(TagToSchedulesDTO dto:scheduleTagDTOS){
//                if(dto.getSchTagName() != null){
//                    tagNames.add(dto.getSchTagName());
//                }
//            }
//            return ResponseEntity.ok("OK");
//        } catch (Exception e) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body(new ScheduleNotFoundException(schId));
//        }
//    }


    // ======================== 以上均經過測試且結果成功 ========================
    // ==================== 以下為經過測試且結果失敗，待查原因 ====================

//    // 測試網頁可以跳轉到設定的路徑，但經過html送出資料後，xhr資料無法抓到資料進入對應的jsp檔案路徑
//    @GetMapping("/test")
//    public void select(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//        String url = "/jsp/GetJson_FromDb.html";
//
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 getAllSche.jsp
//        successView.forward(req, res);
//    }
//
//    // 測試寫法1:老師建議的寫法，待了解結構及測試，只有回傳jsp路徑，沒有導向其他網頁
//    @RequestMapping("/getAllSchedules")
//    public String getAllSchedules(Model model) {
//        List<Schedule> schedule = service.getAll();
//        model.addAttribute("schedules", schedule);
//        return "/jsp/getAllSche.jsp";
//    }
//
//    // 測試寫法2: 原始寫法，可以跳轉網頁，但路徑設定似乎有誤
//    @RequestMapping("/getAllSchedules2")
//    public void getAllSche(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//        String url = "/jsp/getAllSche.jsp";
//
//        List<Schedule> schedules = service.getAll();
//        req.setAttribute("schedules", schedules);
//
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//        successView.forward(req, res);
//    }
//


}
