package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateDTO;
import tw.idv.cha102.g7.attraction.repo.AttrPrivateRepository;
import tw.idv.cha102.g7.attraction.service.AttrPrivateService;

@Service
public class AttrPrivateServiceImpl implements AttrPrivateService {

    @Autowired
    private AttrPrivateRepository attrPrivateRepository;

    @Override
    public AttrPrivateDTO addPrivateAttraction(AttrPrivateDTO attrPrivateDTO){
        return attrPrivateRepository.save(attrPrivateDTO);
    }

}
