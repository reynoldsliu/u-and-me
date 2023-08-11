package tw.idv.cha102.g7.attraction.service;

import tw.idv.cha102.g7.attraction.vo.Attraction;

import java.util.List;

public interface AttractionService {

    Attraction getById(Integer attrId);
    List<Attraction> getAll();
}
