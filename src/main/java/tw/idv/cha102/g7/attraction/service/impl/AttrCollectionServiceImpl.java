package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.cha102.g7.attraction.dto.CollectionDTO;
import tw.idv.cha102.g7.attraction.dto.CollectionId;
import tw.idv.cha102.g7.attraction.repo.AttrCollectionRepository;
import tw.idv.cha102.g7.attraction.repo.AttractionRepository;
import tw.idv.cha102.g7.attraction.service.AttrCollectionService;
import tw.idv.cha102.g7.attraction.service.AttractionService;
import tw.idv.cha102.g7.member.repo.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttrCollectionServiceImpl implements AttrCollectionService {


    @Autowired
    private AttrCollectionRepository attrCollectionRepository;

    @Autowired
    private AttractionRepository attractionRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AttractionService attractionService;


    /**
     * 先查詢有無此會員，以及有無此景點，
     * 若皆有則新增或更新已有的收藏
     * @param collectionDTO
     * @return String
     */
    @Override
    public String addAttrToCollection(CollectionDTO collectionDTO) {
        if (attractionRepository.findById(collectionDTO.getCollectionId().getAttrId()) == null
                || memberRepository.findById(collectionDTO.getCollectionId().getMemId()) == null) {
            return "failed";
        }
        attrCollectionRepository.save(collectionDTO);
        return "success";
    }

    @Override
    @Transactional
    public String removeAttrFromCollection(CollectionId collectionId) {
        if (attrCollectionRepository.findByCollectionId(collectionId) == null) {
            return "failed";
        }
        attrCollectionRepository.deleteByCollectionId(collectionId);
        return "success";

    }


    @Override
    public List<CollectionDTO> findAttrCollectionsByMemId(Integer memId) {
        List<CollectionDTO> dtoList = attrCollectionRepository.findAll();
        System.out.println(memId);
        for(CollectionDTO dto:dtoList){
            if(dto.getCollectionId().getMemId() != memId){
                dtoList.remove(dto);
            }
        }
        return dtoList;
//        return attrCollectionRepository.findByCollectionId((attrCollectionRepository.findByMemId(memId)));
    }


    @Override
    public List<CollectionDTO> findAttrCollectionsByMemName(String memName) {
        Integer memId = memberRepository.findByMemNameContaining(memName).getMemId();
        System.out.println(memId);
        List<CollectionDTO> dtoList = attrCollectionRepository.findAll();
        List<CollectionDTO> returnList = new ArrayList<>();
        System.out.println(memName);
        for(CollectionDTO dto:dtoList){
            if(dto.getCollectionId().getMemId() == memId){
                returnList.add(dto);
            }
        }
        return returnList;
//        return attrCollectionRepository.findByCollectionId((attrCollectionRepository.findByMemId(memId)));
    }
}
