package tw.idv.cha102.g7.attraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

@Controller
@RequestMapping("xxx")
public class AttractionController {


    @Autowired
    private AttractionService attractionService;

    /*
    *
    *
    * */

    //Spring MVC html轉向寫法
//    @GetMapping("/index")
//    public String thymeleafExample(Model model) {
//        model.addAttribute("pageTitle", "Thymeleaf Example");
//        model.addAttribute("message", "Hello, Thymeleaf!");
//        return "index";
//    }

    @GetMapping("/login2")
    public String loginExample(Model model) {
        model.addAttribute("pageTitle", "Login2 Example");
        model.addAttribute("message", "Hello, Login2!");
        return "login2";
    }


    @GetMapping("/getAttr/{attrId}")
    public Attraction getAttr(@PathVariable Integer attrId){
        Attraction attr = attractionService.getById(attrId);
        return attr;
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
    public String getAllAttr(Model model) {
        List<Attraction> attraction = attractionService.getAll();
        model.addAttribute("attractions", attraction);
        return "/jsp/getAllAttr.jsp";
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

    @RequestMapping("/attraction/index")
    public void ajax(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/jsp/index.jsp";

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

    @RequestMapping("/ajax")
    public void showWebPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/jsp/ajax.jsp";
        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

    @RequestMapping("/yt")
    public void showYtPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/jsp/yt_layout.jsp";
        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

}
