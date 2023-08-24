package tw.idv.cha102.g7.attraction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionDTO;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionId;
import tw.idv.cha102.g7.attraction.service.AttrCollectionService;

@RestController
public class AttrCollectionController {

    @Autowired
    private AttrCollectionService attrCollectionService;

    /**
     * 加入景點收藏
     * @param attrCollectionDTO
     * @return String "success" or "failed"
     */
    @PostMapping("/addAttrToCollection")
    public String addAttrToCollection(@RequestBody AttrCollectionDTO attrCollectionDTO) {
        if(attrCollectionService.addAttrToCollection(attrCollectionDTO) == "success")
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
     * @param collectionId
     * @return String "success" or "failed"
     */
    @RequestMapping("/removeAttrFromCollection")
    public String removeAttrFromCollection(@RequestBody AttrCollectionId collectionId){
        if(attrCollectionService.removeAttrFromCollection(collectionId) == "success")
            return "success";
        else
            return "failed";
    }
    /*
    * {
  		    "memId":3,
  		    "attrId": 2
	   }
    * */


}
