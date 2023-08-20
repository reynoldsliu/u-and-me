package tw.idv.cha102.g7.attraction.service;

import tw.idv.cha102.g7.attraction.entity.Attraction;

import java.util.List;

public interface AttractionService {

    Attraction getById(Integer attrId);

    String createAttr(Attraction attraction);
    List<Attraction> getAll();

    void setSta(Integer attrId, Short attrSta);
}
