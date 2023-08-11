package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.attraction.vo.Attraction;
import tw.idv.cha102.g7.schedule.dao.impl.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleService;
import tw.idv.cha102.g7.schedule.vo.Schedule;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/schedules")
    public void insert(@RequestBody Schedule schedule){
        scheduleService.insert(schedule);
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
        return scheduleService.getById(schId);
    }

    @GetMapping("/schedules")
    public List<Schedule> selectAll(){
        return  scheduleService.getAll();
    }

    @RequestMapping("/selectAllSchedules")
    public void selectAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/jsp/getAllSche.jsp";

        List<Schedule> schedules = scheduleService.getAll();
        req.setAttribute("schedules", schedules);

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }
}
