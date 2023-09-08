package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionDTO;
import tw.idv.cha102.g7.attraction.dto.AttrCollectionId;
import tw.idv.cha102.g7.attraction.entity.Attraction;
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
     * 若皆有則刪除已有的收藏
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
     * 透過會員編號，找出該會員的所有景點收藏
     * @param memId
     * @return List<AttrCollectionDTO>
     */
    @Override
    public List<AttrCollectionDTO> findAttrsByMemId(Integer memId) {
        List<AttrCollectionDTO> dtoList = attrCollectionRepository.findAll();
        List<AttrCollectionDTO> returnList = new ArrayList<>();
        System.out.println(memId);
        for(AttrCollectionDTO dto:dtoList){
            if(dto.getCollectionId().getMemId() == memId){
                returnList.add(dto);
            }
        }
        return returnList;
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

    /**
     * 透過會員編號，找出該會員的所有景點收藏 過濾已下架景點
     *
     * @param memId
     * @return List<AttrCollectionDTO>
     */
    @Override
    public List<Attraction> findAttrsByMemIdFilter(Integer memId){
        List<Attraction> returnList = new ArrayList<>();
        List<AttrCollectionDTO> attrCollectionDTOList = attrCollectionRepository.findAll();
        for(AttrCollectionDTO attrCollectionDTO:attrCollectionDTOList){
            Attraction attraction = attrRepository.findById(attrCollectionDTO.getCollectionId().getAttrId()).orElse(null);
            if(attrCollectionDTO.getCollectionId().getMemId()==memId &&
                        attraction.getAttrSta()!=0){
                returnList.add(attraction);
            }
        }
        return returnList;
    }

    @Override
    public List<AttrCollectionDTO> findAttrCollectionsByAttrName(
            Integer memId,
            String attrName
    ){
        List<Attraction> attractions = attrRepository.findAllByAttrNameContaining(attrName);
        List<Integer> attrIds = new ArrayList<>();
        for(Attraction attraction:attractions){
            attrIds.add(attraction.getAttrId());
        }

        List<AttrCollectionDTO> attrCollectionDTOS = attrCollectionRepository.findAll();
        List<AttrCollectionDTO> returnList = new ArrayList<>();
        for(AttrCollectionDTO attrCollectionDTO:attrCollectionDTOS){
            for(Integer attrId:attrIds){
                if(attrCollectionDTO.getCollectionId().getAttrId()==attrId
                        &&!returnList.contains(attrCollectionDTO)){
                    returnList.add(attrCollectionDTO);
                }
            }
        }
        return returnList;

    }
}
