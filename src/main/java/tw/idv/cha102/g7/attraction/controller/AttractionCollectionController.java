package tw.idv.cha102.g7.attraction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.attraction.dto.CollectionDTO;
import tw.idv.cha102.g7.attraction.dto.CollectionId;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.attraction.service.AttrCollectionService;
import tw.idv.cha102.g7.attraction.service.AttractionService;

@RestController
public class AttractionCollectionController {

    @Autowired
    private AttrCollectionService attrCollectionService;

    /**
     * 加入景點收藏
     */
    @PostMapping("/addAttrToCollection")
    public String addAttrToCollection(@RequestBody CollectionDTO collectionDTO) {
        if(attrCollectionService.addAttrToCollection(collectionDTO) == "success")
            return "success";
        else
            return "failed";

    }
    /*{
        "collectionId": {
  		    "memId":3,
  		    "attrId": 2
	            },

	    "attrColIlla": "第三個會員對第二個景點"
    }*/


    /**
     * 移除景點收藏
     */
    @RequestMapping("/removeAttrFromCollection")
    public String removeAttrFromCollection(@RequestBody CollectionId collectionId){
        if(attrCollectionService.removeAttrFromCollection(collectionId) == "success")
            return "success";
        else
            return "failed";
    }


}
