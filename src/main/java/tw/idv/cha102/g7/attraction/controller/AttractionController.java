package tw.idv.cha102.g7.attraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.idv.cha102.g7.attraction.vo.Attraction;
import tw.idv.cha102.g7.attraction.service.AttractionService;
import tw.idv.cha102.g7.attraction.AttractionRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AttractionController {

//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private AttractionService attractionService;

    /*
    *
    *
    * */

    @Autowired
    private AttractionRepository attractionRepository;

    @GetMapping("/thymeleaf")
    public String thymeleafExample(Model model) {
        model.addAttribute("pageTitle", "Thymeleaf Example");
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "index";
    }

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


    @RequestMapping("/getOneAttr")
    public void getOneAttr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/jsp/getOneAttr.jsp";

        Attraction attraction = attractionService.getById(1);
        HttpSession session = req.getSession();
        session.setAttribute("attraction", attraction);

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

    @RequestMapping("/getAllAttr")
    public String getAllAttr(Model model) {
        List<Attraction> attraction = attractionService.getAll();
        model.addAttribute("attractions", attraction);
        return "/jsp/getAllAttr.jsp";
    }

    @RequestMapping("/getAllAttr")
    public void getAllAttr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/jsp/getAllAttr.jsp";

        List<Attraction> attraction = attractionService.getAll();
        req.setAttribute("attractions", attraction);

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        req.setAttribute("name","BLOGGER");
//        System.out.println("ininininin");
        String url = "/jsp/hello.jsp";

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);

    }

    @RequestMapping("/index")
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

//    @PostMapping("/students")
//    public String insert(){
//
////            String sql = "select * from attractions";
////            Map<String,Object> map = new HashMap<>();
////
////            namedParameterJdbcTemplate.update(sql,map);
//        return "select success";
//    }
//
//    @GetMapping("/getAllAttr/{attrId}")
//    public ResponseEntity<AttrDao> selectAttr(@PathVariable Integer attrId){
//        String sql = "select * from attractions where attr_id = :attrId";
//        Map<String, Object> map = new HashMap<>();
//        map.put("attrId",attrId);
//
//        AttrDao attrDao = namedParameterJdbcTemplate.queryForObject(sql, map, new RowMapper<AttrDao>() {
//            @Override
//            public AttrDao mapRow(ResultSet rs, int rowNum) throws SQLException {
//                AttrDao attrDao = new AttrDao();
//                attrDao.setId(rs.getInt("attr_id"));
////                user.setUserName(rs.getString("USER_NAME"));
//
//                return attrDao;
//            }
//        });
//        return ResponseEntity.status(200).body(attrDao);
//    }
}
