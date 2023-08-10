package tw.idv.cha102.g7.attr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.attr.service.AttrService;
import tw.idv.cha102.g7.attr.Attr;
import tw.idv.cha102.g7.attr.AttrRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class AttrController {

//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrRepository attrRepository;

    @GetMapping("/getAttr/{attrId}")
    public Attr getAttr(@PathVariable Integer attrId){
        Attr attr = attrService.getById(attrId);
        return attr;

    }


    @RequestMapping("/getOneAttr")
    public void getOneAttr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/show/getOneAttr.jsp";

        Attr attr = attrService.getById(1);
        req.setAttribute("attrVO",attr);

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

    @RequestMapping("/getAllAttr")
    public void getAllAttr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = "/show/getAllAttr.jsp";

        List<Attr> attrs = attrService.getAll();
        req.setAttribute("attrs",attrs);

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        req.setAttribute("name","BLOGGER");
//        System.out.println("ininininin");
        String url = "/show/hello.jsp";

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);

    }

    @RequestMapping("/index")
    public void ajax(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/show/index.jsp";

        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);

    }

    @RequestMapping("/ajax")
    public void showWebPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/show/ajax.jsp";
        RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
        successView.forward(req, res);
    }

    @RequestMapping("/yt")
    public void showYtPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "/show/yt_layout.jsp";
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
