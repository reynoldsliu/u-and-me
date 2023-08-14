package tw.idv.cha102.g7.attraction.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.attraction.repo.AttractionRepository;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.attraction.service.AttractionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
//@RequestMapping("/attr")
public class AttractionController {


    @Autowired
    private AttractionService attractionService;

    /*
    *
    *
    * */

    //Spring MVC html轉向寫法
    @GetMapping("/index")
    public String thymeleafExample(Model model) {
        model.addAttribute("pageTitle", "Thymeleaf Example");
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("pageTitle", "Thymeleaf Example");
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "register";
    }

//    @GetMapping("/login2")
//    public String loginExample(Model model) {
//        model.addAttribute("pageTitle", "Login2 Example");
//        model.addAttribute("message", "Hello, Login2!");
//        return "login2";
//    }


    @RequestMapping("/getAttr")
    public Attraction getAttr(@RequestParam Integer attrId){
        return attractionService.getById(attrId);
    }


//    @RequestMapping("/getOneAttr")
//    public void getOneAttr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//        String url = "/jsp/getOneAttr.jsp";
//
//        Attraction attraction = attractionService.getById(1);
//        HttpSession session = req.getSession();
//        session.setAttribute("attraction", attraction);
//
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//        successView.forward(req, res);
//    }


    //Spring MVC html轉向寫法
    @RequestMapping("/getAllAttr")
    public List<Attraction> getAllAttr(/*Model model*/) {
        List<Attraction> attraction = attractionService.getAll();
//        model.addAttribute("attractions", attraction);
        return attraction;
    }


    //SERVLET 轉向寫法
//    @RequestMapping("/getAllAttr")
//    public void getAllAttr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//        String url = "/jsp/getAllAttr.jsp";
//
//        List<Attraction> attraction = attractionService.getAll();
//        req.setAttribute("attractions", attraction);
//
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//        successView.forward(req, res);
//    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/jsp/hello.jsp";

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);

    }

//    @RequestMapping("/index")
//    public void ajax(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String url = "/jsp/index.jsp";
//
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//        successView.forward(req, res);
//    }

//    @RequestMapping("/yt")
//    public void showYtPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String url = "/jsp/yt_layout.jsp";
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//        successView.forward(req, res);
//    }

    @RequestMapping("/yt")
    public String goto_yt(Model model) {

        return "yt_layout";
    }

    @GetMapping("/json-data")
    public Attraction postJsonData(HttpServletRequest request) throws JsonProcessingException {
        // 在这里处理接收到的 JSON 数据
        Attraction attraction = attractionService.getById(1);

        System.out.println("HIIIIIIII");

            final HttpSession session = request.getSession();
            session.setAttribute("loggedin", true);
            session.setAttribute("attraction", attraction);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(attraction);

        return attraction;
    }

    @RequestMapping("/bootstrap12")
    public String goto_bootstrap12(Model model) {

        return "bootstrap12";
    }

    @GetMapping("/getAttraction/{id}")
    public ResponseEntity<Attraction> getAttractionById(@PathVariable Integer id) {
        Attraction attraction = attractionService.getById(id);
        System.out.println("in");
        if (attraction != null) {
            System.out.println("success to found");
            System.out.println(attraction.toString());
            return ResponseEntity.ok(attraction);
        } else {
            System.out.println("fail to found");
            System.out.println(attraction.toString());
            return ResponseEntity.notFound().build();
        }
    }

}
