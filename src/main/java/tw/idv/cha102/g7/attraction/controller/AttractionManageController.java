package tw.idv.cha102.g7.attraction.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.activity.repository.ActivityRepository;
import tw.idv.cha102.g7.activity.service.ActivityService;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.attraction.service.AttractionService;

@RestController
public class AttractionManageController {

    @Autowired
    private AttractionService attractionService;

    /*
    * 查看景點詳情
    * */

    @RequestMapping("/attr/{attrId}")
    public Attraction getAttrDetailById(@PathVariable Integer attrId){
        Attraction attraction = attractionService.getById(attrId);
        String attractionJson = JSONObject.toJSONString(attraction);
        return attraction;
    }


    /*
     * 景點審核通過
     * */
    @RequestMapping("/attr/setAttrVeriSta/{attrId}/{attrVeriSta}")
    public String setAttrVeriSta(@PathVariable Integer attrId, @PathVariable Short attrVeriSta){
        Attraction attraction = attractionService.getById(attrId);
        if(attraction != null){
            attractionService.getById(attrId).setSta(attrVeriSta);
        }
        else{
            return "Attraction Not Found.";
        }
        return "Set Attraction Status to : "+attrVeriSta;
    }

    /*
     * 景點資訊上下架
     * */
    @RequestMapping("/attr/setAttrSta/{attrId}/{attrSta}")
    public String setAttrSta(@PathVariable Integer attrId, @PathVariable Short attrSta){
        Attraction attraction = attractionService.getById(attrId);
        if(attraction != null){
            attractionService.setSta(attrId,attrSta);
        }
        else{
            return "Attraction Not Found.";
        }
        return "Set Attraction id=" + attrId + "Status to : " + attrSta;
    }

    /*
     * 增刪改查景點
     * */
    @RequestMapping("/attr/createAttr")
    public String createAttr(@RequestBody Attraction attraction){
        if(attractionService.createAttr(attraction) == "success"){
            return "success";
        }
        else{
            return "failed";
        }
    }

}
