package tw.idv.cha102.g7.attr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AttrController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/students")
    public String insert(){

//            String sql = "select * from attractions";
//            Map<String,Object> map = new HashMap<>();
//
//            namedParameterJdbcTemplate.update(sql,map);
        return "select success";
    }

    @GetMapping("/getAllAttr/{attrId}")
    public ResponseEntity<AttrVO> selectAttr(@PathVariable Integer attrId){
        String sql = "select * from attractions where attr_id = :attrId";
        Map<String, Object> map = new HashMap<>();
        map.put("attrId",attrId);

        AttrVO attrVO = namedParameterJdbcTemplate.queryForObject(sql, map, new RowMapper<AttrVO>() {
            @Override
            public AttrVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                AttrVO attrVO = new AttrVO();
                attrVO.setId(rs.getInt("attr_id"));
//                user.setUserName(rs.getString("USER_NAME"));

                return attrVO;
            }
        });
        return ResponseEntity.status(200).body(attrVO);
    }
}
