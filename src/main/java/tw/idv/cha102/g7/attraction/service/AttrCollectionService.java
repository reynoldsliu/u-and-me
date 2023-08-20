package tw.idv.cha102.g7.attraction.service;


import tw.idv.cha102.g7.attraction.dto.CollectionDTO;
import tw.idv.cha102.g7.attraction.dto.CollectionId;
import tw.idv.cha102.g7.attraction.entity.Attraction;

import java.util.List;

public interface AttrCollectionService {
    String addAttrToCollection(CollectionDTO collectionDTO);
    String removeAttrFromCollection(CollectionId collectionId);

    List<CollectionDTO> findAttrCollectionsByMemId(Integer memId);
    List<CollectionDTO> findAttrCollectionsByMemName(String memName);
}
