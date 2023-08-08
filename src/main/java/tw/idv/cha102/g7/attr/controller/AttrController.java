package tw.idv.cha102.g7.attr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.attr.Attr;
import tw.idv.cha102.g7.attr.AttrRepository;
import tw.idv.cha102.g7.attr.service.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        request.setAttribute("name","BLOGGER");


        return "hello.jsp"; // 對應到 hello.jsp
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
