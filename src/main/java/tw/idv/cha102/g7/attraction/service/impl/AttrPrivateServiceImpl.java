package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateDTO;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateId;
import tw.idv.cha102.g7.attraction.repo.AttrPrivateRepository;
import tw.idv.cha102.g7.attraction.service.AttrPrivateService;

@Service
public class AttrPrivateServiceImpl implements AttrPrivateService {

    @Autowired
    private AttrPrivateRepository attrPrivateRepository;

    /**
     * 新增或修改一個私人景點到私人景點資料庫
     * @param attrPrivateDTO
     * @return AttrPrivateDTO
     */
    @Override
    public AttrPrivateDTO addAndUpdatePrivateAttraction(AttrPrivateDTO attrPrivateDTO){
        return attrPrivateRepository.save(attrPrivateDTO);
    }

    @Override
    public String deletePrivateAttraction(AttrPrivateId attrPrivateId){
        try{
            attrPrivateRepository.deleteByAttrPrivateId(attrPrivateId);
        }catch(Exception e){
            return "delete private attraction failed.";
        }
        return "delete private attraction success.";
    }

    @Override
    public AttrPrivateDTO getPrivateAttraction(AttrPrivateId attrPrivateId){
        return attrPrivateRepository.findByAttrPrivateId(attrPrivateId);
    }



}
