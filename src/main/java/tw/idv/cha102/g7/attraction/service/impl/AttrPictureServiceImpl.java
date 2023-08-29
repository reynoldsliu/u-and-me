package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.attraction.dto.AttrPictureDTO;
import tw.idv.cha102.g7.attraction.repo.AttrPictureRepository;
import tw.idv.cha102.g7.attraction.service.AttrPictureService;

import java.util.List;

@Service
public class AttrPictureServiceImpl implements AttrPictureService {

    @Autowired
    AttrPictureRepository attrPictureRepository;

    @Override
    public ResponseEntity<AttrPictureDTO> insertPictures(AttrPictureDTO attrPictureDTO){
        AttrPictureDTO a = attrPictureRepository.save(attrPictureDTO);
        System.out.println("IN serviceIMPL");
        return new ResponseEntity(a, HttpStatus.OK);
    }
}
