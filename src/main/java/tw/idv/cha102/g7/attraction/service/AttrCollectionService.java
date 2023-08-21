package tw.idv.cha102.g7.attraction.service;


import tw.idv.cha102.g7.attraction.dto.AttrCollectionDTO;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionId;

import java.util.List;

public interface AttrCollectionService {
    String addAttrToCollection(AttrCollectionDTO attrCollectionDTO);
    String removeAttrFromCollection(AttrCollectionId collectionId);

    List<AttrCollectionDTO> findAttrCollectionsByMemId(Integer memId);
    List<AttrCollectionDTO> findAttrCollectionsByMemName(String memName);
}
