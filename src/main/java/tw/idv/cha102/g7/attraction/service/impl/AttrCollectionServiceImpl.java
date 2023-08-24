package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionDTO;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionId;
import tw.idv.cha102.g7.attraction.repo.AttrCollectionRepository;
import tw.idv.cha102.g7.attraction.repo.AttrRepository;
import tw.idv.cha102.g7.attraction.service.AttrCollectionService;
import tw.idv.cha102.g7.attraction.service.AttrService;
import tw.idv.cha102.g7.member.repo.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttrCollectionServiceImpl implements AttrCollectionService {


    @Autowired
    private AttrCollectionRepository attrCollectionRepository;

    @Autowired
    private AttrRepository attrRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AttrService attrService;


    /**
     * 先查詢有無此會員，以及有無此景點，
     * 若皆有則新增或更新已有的收藏
     * @param attrCollectionDTO
     * @return String
     */
    @Override
    public String addAttrToCollection(AttrCollectionDTO attrCollectionDTO) {
        if (attrRepository.findById(attrCollectionDTO.getCollectionId().getAttrId()) == null
                || memberRepository.findById(attrCollectionDTO.getCollectionId().getMemId()) == null) {
            return "failed";
        }
        attrCollectionRepository.save(attrCollectionDTO);
        return "success";
    }


    /**
     * 先查詢有無此會員，以及有無此景點，
     * 若皆有則新增或更新已有的收藏
     * @param attrCollectionId
     * @return String "success" or "failed"
     */
    @Override
    @Transactional
    public String removeAttrFromCollection(AttrCollectionId attrCollectionId) {
        if (attrCollectionRepository.findByCollectionId(attrCollectionId) == null) {
            return "failed";
        }
        attrCollectionRepository.deleteByCollectionId(attrCollectionId);
        return "success";

    }

    /**
     * 透過會員標號，找出該會員的所有景點收藏
     * @param memId
     * @return List<AttrCollectionDTO>
     */
    @Override
    public List<AttrCollectionDTO> findAttrCollectionsByMemId(Integer memId) {
        List<AttrCollectionDTO> dtoList = attrCollectionRepository.findAll();
        System.out.println(memId);
        for(AttrCollectionDTO dto:dtoList){
            if(dto.getCollectionId().getMemId() != memId){
                dtoList.remove(dto);
            }
        }
        return dtoList;
//        return attrCollectionRepository.findByCollectionId((attrCollectionRepository.findByMemId(memId)));
    }

    /**
     * 透過會員名稱，找出該會員的所有景點收藏
     * @param memName
     * @return List<AttrCollectionDTO>
     */
    @Override
    public List<AttrCollectionDTO> findAttrCollectionsByMemName(String memName) {
        Integer memId = memberRepository.findByMemNameContaining(memName).getMemId();
        System.out.println(memId);
        List<AttrCollectionDTO> dtoList = attrCollectionRepository.findAll();
        List<AttrCollectionDTO> returnList = new ArrayList<>();
        System.out.println(memName);
        for(AttrCollectionDTO dto:dtoList){
            if(dto.getCollectionId().getMemId() == memId){
                returnList.add(dto);
            }
        }
        return returnList;
//        return attrCollectionRepository.findByCollectionId((attrCollectionRepository.findByMemId(memId)));
    }
}
