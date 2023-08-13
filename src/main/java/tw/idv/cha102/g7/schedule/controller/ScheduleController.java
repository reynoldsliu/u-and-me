package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.schedule.service.ScheduleService;
import tw.idv.cha102.g7.schedule.vo.Schedule;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/schedules")
    public Schedule insert(@RequestBody Schedule schedule){
        return scheduleService.add(schedule);
    }

    @DeleteMapping("/schedules/{schId}")
    public void delete(@PathVariable Integer schId){
        scheduleService.deleteById(schId);
    }

    @PutMapping("/schedules/{schId}")
    public void update(@PathVariable Integer schId,
                       @RequestBody Schedule schedule){
        scheduleService.updateById(schId, schedule);
    }

    @GetMapping("/schedules/{schId}")
    public Schedule select(@PathVariable Integer schId){
        return scheduleService.findById(schId);
    }

    @GetMapping("/test")
    public void select(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/jsp/GetJson_FromDb.html";

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 getAllSche.jsp
        successView.forward(req, res);
    }

    @GetMapping("/schedules")
    public List<Schedule> selectAll(){
        return  scheduleService.getAllSchedules();
    }

    @RequestMapping("/selectAllSchedules")
    public void selectAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/jsp/getAllSche.jsp";

        List<Schedule> schedules = scheduleService.getAllSchedules();
        req.setAttribute("schedules", schedules);

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 getAllSche.jsp
        successView.forward(req, res);
    }

//    @GetMapping("/testsche2/{schStart}/{schEnd}")
    @RequestMapping(value = "/testsche2", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Schedule> findBetweenDate(@RequestBody Schedule schedule){
        List<Schedule> schedules = scheduleService.findBetweenDate(schedule.getSchStart(), schedule.getSchEnd());
        return schedules;
    }

    @GetMapping("/testsche/{schName}")
    public List<Schedule> findBySchName(@PathVariable String schName){
        return scheduleService.findBySchName(schName);
    }
}
