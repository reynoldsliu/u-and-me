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
import java.util.stream.Collectors;

// 瀏覽公開行程
@RestController
@RequestMapping("/schedules")
public class ScheduleSearchController {

    @Autowired
    private ScheduleService service;

    /**
     * 一般使用者
     * 查詢所有最新公開行程並依分頁顯示
     *
     * @param page 當前分頁 (從0開始)(暫定顯示每頁6筆行程)
     * @return 返回所有公開行程列表
     */
    @GetMapping("/all/{page}")
    public List<Schedule> findAllPublic(@PathVariable int page) {
        return service.findAllPublicPaged(page, 6);
    }

    /**
     * 一般使用者
     * 以行程名稱查詢行程
     *
     * @param keyword 欲查詢的名稱
     * @return 返回查詢結果
     */
    @GetMapping("/{keyword}/{page}")
    public List<Schedule> findBySchName(@PathVariable String keyword,
                                        @PathVariable int page) {
        return service.findBySchNamePaged(keyword, page).collect(Collectors.toList());
    }

    /**
     * 一般使用者
     * 以行程開始日期及結束日期，查詢期限內的行程
     *
     * @param schStart 行程開始日期
     * @param schEnd   行程結束日期
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
     *
     * @return 返回查詢結果
     */
    @GetMapping(value = "/days/{page}")
    public List<ScheduleDayDTO> findOrderByDays(@PathVariable int page) {
        List<ScheduleDayDTO> schedules = service.findOrderByDays(page).collect(Collectors.toList());
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
     *
     * @return 返回查詢結果
     */
    @GetMapping("/schId/{schId}")
    public Schedule getOne(@PathVariable Integer schId) {
        return service.getById(schId);
    }

}
