package tw.idv.cha102.g7.attraction.service;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionDTO;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionId;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.member.entity.Member;

import java.util.List;
import java.util.TreeSet;

public interface AttrCollectionService {
    public String addAttrToCollection(AttrCollectionDTO attrCollectionDTO);
    public String removeAttrFromCollection(AttrCollectionId collectionId);
    public TreeSet<Member> returnMemsByAttrId(Integer attrId);

    public List<AttrCollectionDTO> findAttrsByMemId(Integer memId);
    public List<Attraction> findAttrsByMemIdFilter(Integer memId);
    public List<AttrCollectionDTO> findAttrCollectionsByMemName(String memName);

    public List<AttrCollectionDTO> findAttrCollectionsByAttrName(Integer memId, String attrName);
}
