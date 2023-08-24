package tw.idv.cha102.g7.attraction.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionDTO;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.attraction.service.AttrCollectionService;
import tw.idv.cha102.g7.attraction.service.AttrService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import tw.idv.cha102.g7.member.service.MemberService;

@Controller
//@RequestMapping("/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;
    @Autowired
    private MemberService memberService;


    //Spring MVC html轉向寫法
    @GetMapping("/index")
    public String thymeleafExample(Model model) {
        model.addAttribute("pageTitle", "Thymeleaf Example");
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "index";
    }

    @RequestMapping("/AttractionPage")
    public String AttractionPage(){
        return "AttractionPage";
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
        return attrService.getById(attrId);
    }


//    @RequestMapping("/getOneAttr")
//    public void getOneAttr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//        String url = "/jsp/getOneAttr.jsp";
//
//        Attraction attraction = attrService.getById(1);
//        HttpSession session = req.getSession();
//        session.setAttribute("attraction", attraction);
//
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//        successView.forward(req, res);
//    }


    //Spring MVC html轉向寫法
    @RequestMapping("/getAllAttr")
    public List<Attraction> getAllAttr(/*Model model*/) {
        List<Attraction> attraction = attrService.getAll();
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

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/json-data")
    public Attraction postJsonData(HttpServletRequest request) throws JsonProcessingException {
        // 在这里处理接收到的 JSON 数据
        Attraction attraction = attrService.getById(1);

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
    public String getAttractionById(@PathVariable Integer id) throws JsonProcessingException {
        Attraction attraction = attrService.getById(id);
        System.out.println("in");
        System.out.println(attraction);
        if (attraction != null) {
            String attractionJson = JSONObject.toJSONString(attraction);
//            JSONObject.
            return attractionJson;
//            writePojo2Json(ResponseEntity<attraction>,attraction);
//
//            return ResponseEntity.ok(attraction.toString());
        } else {
            return null;
        }
    }

    @Autowired
    private AttrCollectionService attrCollectionService;
    @GetMapping("/getCollectionAttrsByMemId/{memId}")
    public List<AttrCollectionDTO> getCollectionAttrsByMemId(@PathVariable Integer memId){
        return attrCollectionService.findAttrCollectionsByMemId(memId);
    }

    @RequestMapping("/getCollectionAttrsByMemName/{memName}")
    public List<AttrCollectionDTO> findAttrCollectionsByMemName(@PathVariable String memName){
        List<AttrCollectionDTO> attrCollectionDTOS =
                attrCollectionService.findAttrCollectionsByMemName(memName);
        if(attrCollectionDTOS == null)
            return null;
        else
            return attrCollectionDTOS;
    }



}
