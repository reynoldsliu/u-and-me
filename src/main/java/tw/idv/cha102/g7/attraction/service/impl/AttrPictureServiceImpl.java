package tw.idv.cha102.g7.attraction.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.attraction.dto.AttrPictureDTO;
import tw.idv.cha102.g7.attraction.entity.AttrPicture;
import tw.idv.cha102.g7.attraction.repo.AttrPictureRepository;
import tw.idv.cha102.g7.attraction.service.AttrPictureService;

import java.util.List;

@Service
public class AttrPictureServiceImpl implements AttrPictureService {
    @Autowired
    AttrPictureRepository attrPictureRepository;

    @Override
    public ResponseEntity<AttrPicture> insertPictures(AttrPicture attrPicture){
        return new ResponseEntity(attrPictureRepository.save(attrPicture), HttpStatus.OK);
    }

    @Override
    public String getPicsByAttrId(Integer attrId){
        List<AttrPicture> attrPictures = attrPictureRepository.findAllByAttrId(attrId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("attrPic",attrPictures);

        return jsonObject.toJSONString();
    }
}
