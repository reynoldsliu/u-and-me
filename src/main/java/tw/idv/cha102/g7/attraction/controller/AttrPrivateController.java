package tw.idv.cha102.g7.attraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateDTO;
import tw.idv.cha102.g7.attraction.service.AttrPrivateService;

@RestController
public class AttrPrivateController {

    @Autowired
    private AttrPrivateService attrPrivateService;
    /*
     * 新增個人景點
     * */
    @PostMapping("/createPrivateAttr")
    public AttrPrivateDTO createPrivateAttr(@RequestBody AttrPrivateDTO attrPrivateDTO){
        return attrPrivateService.addPrivateAttraction(attrPrivateDTO);
    }

    /*
     * 修改個人景點
     * */

    /*
     * 刪除個人景點
     * */

    /*
     * 查詢個人景點
     * */



}
