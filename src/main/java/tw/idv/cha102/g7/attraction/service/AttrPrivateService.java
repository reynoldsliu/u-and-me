package tw.idv.cha102.g7.attraction.service;

import tw.idv.cha102.g7.attraction.dto.AttrPrivateDTO;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateId;

public interface AttrPrivateService {

    public AttrPrivateDTO addAndUpdatePrivateAttraction(AttrPrivateDTO attrPrivateDTO);

    public String deletePrivateAttraction(AttrPrivateId attrPrivateId);

    public AttrPrivateDTO getPrivateAttraction(AttrPrivateId attrPrivateId);
}
