package tw.idv.cha102.g7.attraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateDTO;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateId;
import tw.idv.cha102.g7.attraction.service.AttrPrivateService;

@RestController
public class AttrPrivateController {

    @Autowired
    private AttrPrivateService attrPrivateService;

    /**
     * 新增一個私人景點到私人景點資料庫
     * @param attrPrivateDTO
     * @return AttrPrivateDTO
     */
    @PostMapping("/createPrivateAttr")
    public AttrPrivateDTO createPrivateAttr(@RequestBody AttrPrivateDTO attrPrivateDTO){
        return attrPrivateService.addAndUpdatePrivateAttraction(attrPrivateDTO);
    }

    /**
     * 修改一個私人景點
     * @param attrPrivateDTO
     * @return AttrPrivateDTO
     */
    @RequestMapping("/updatePrivateAttr")
    public AttrPrivateDTO updatePrivateAttr(@RequestBody AttrPrivateDTO attrPrivateDTO){
        return attrPrivateService.addAndUpdatePrivateAttraction(attrPrivateDTO);
    }

    /**
     * 刪除一個私人景點
     * @param attrPrivateId
     * @return
     */
    @RequestMapping("/daletePrivateAttraction")
    public String daletePrivateAttraction(@RequestBody AttrPrivateId attrPrivateId){
        return attrPrivateService.deletePrivateAttraction(attrPrivateId);
    }

    /**
     * 查詢一個私人景點
     * @param attrPrivateId
     * @return AttrPrivateDTO
     */
    @RequestMapping("/getPrivateAttraction")
    public AttrPrivateDTO getPrivateAttraction(@RequestBody AttrPrivateId attrPrivateId){
        return attrPrivateService.getPrivateAttraction(attrPrivateId);
    }


}
