package tw.idv.cha102.g7.attraction.service;


import tw.idv.cha102.g7.attraction.dto.AttrCollectionDTO;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionId;
import tw.idv.cha102.g7.attraction.entity.Attraction;

import java.util.List;

public interface AttrCollectionService {
    public String addAttrToCollection(AttrCollectionDTO attrCollectionDTO);
    public String removeAttrFromCollection(AttrCollectionId collectionId);

    public List<AttrCollectionDTO> findAttrsByMemId(Integer memId);
    public List<Attraction> findAttrsByMemIdFilter(Integer memId);
    public List<AttrCollectionDTO> findAttrCollectionsByMemName(String memName);

    public List<AttrCollectionDTO> findAttrCollectionsByAttrName(Integer memId, String attrName);
}
