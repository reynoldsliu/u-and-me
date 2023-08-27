package tw.idv.cha102.g7.attraction.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.member.service.MemberService;

@RestController
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

//    @RequestMapping("/AttractionPage")
//    public void AttractionPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String url = "/AttractionPage";
//
//
//        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//        successView.forward(req, res);
//
//    }

//    @Autowired
//    private ResourceLoader resourceLoader;

    @RequestMapping("/AttractionPage")
    public void AttractionPage(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        String redirectUrl = "AttractionPage.html"; // 設定要重定向的目標 URL
        res.sendRedirect(redirectUrl);
    }

    @RequestMapping("/listAllAttraction")
    public void listAllAttraction(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        String redirectUrl = "listAllAttraction.html"; // 設定要重定向的目標 URL
        System.out.println(res);
        res.sendRedirect(redirectUrl);
    }

//    @GetMapping("/AttractionPage")
//    public ResponseEntity<String> AttractionPage(HttpServletResponse res) throws IOException {
//        String url = "{\"redirect\": \"AttractionPage.html\"}";
//        System.out.println("printprintprintprint"+ResponseEntity.ok(url));
//        return ResponseEntity.ok(url);
//         //res.sendRedirect("AttractionPage");
//    }


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
    public Attraction getAttr(@RequestParam Integer attrId) {
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

    @RequestMapping("/getAttrsByName/{attrName}")
    public List<Attraction> getAttrsByName(@PathVariable String attrName){
        return attrService.getAttrsByName(attrName);
    }

    @GetMapping("/attr/all/{pageSize}/{page}")
    public List<Attraction> getAllPaged(@PathVariable Integer pageSize,@PathVariable Integer page){
        return attrService.getAllPaged(page,pageSize);
    }

    @GetMapping("/attr/{attrName}/{pageSize}/{page}")
    public List<Attraction> getAllPaged(@PathVariable String attrName,
                                        @PathVariable Integer pageSize,
                                        @PathVariable Integer page){

        Page<Attraction> pageResult = attrService.getAllPagedByName(attrName,page,pageSize);
        System.out.println(pageResult.getContent());
        return pageResult.getContent();
    }

    @PostMapping("/getNumOfResult")
    public Integer getNumOfResult(@RequestBody List<Attraction> attrList){
        int count = 0;
//        List<Attraction> list = attrList;
        for(Attraction attr:attrList){
            if(attrList.size()==0){
                return count;
            }
            attrList.remove(attr);
            count++;
        }
        return 0;
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
    public List<AttrCollectionDTO> getCollectionAttrsByMemId(@PathVariable Integer memId) {
        return attrCollectionService.findAttrCollectionsByMemId(memId);
    }

    @RequestMapping("/getCollectionAttrsByMemName/{memName}")
    public List<AttrCollectionDTO> findAttrCollectionsByMemName(@PathVariable String memName) {
        List<AttrCollectionDTO> attrCollectionDTOS =
                attrCollectionService.findAttrCollectionsByMemName(memName);
        if (attrCollectionDTOS == null)
            return null;
        else
            return attrCollectionDTOS;
    }


}
