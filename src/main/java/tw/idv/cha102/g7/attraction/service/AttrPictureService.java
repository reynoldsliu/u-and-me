package tw.idv.cha102.g7.attraction.service;

import org.springframework.http.ResponseEntity;
import tw.idv.cha102.g7.attraction.dto.AttrPictureDTO;

import java.util.List;

public interface AttrPictureService {

    public ResponseEntity<AttrPictureDTO> insertPictures(AttrPictureDTO attrPictureDTO);

}
