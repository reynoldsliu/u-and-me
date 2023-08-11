package tw.idv.cha102.g7.attraction.dao;

import tw.idv.cha102.g7.attraction.vo.Attraction;

import java.util.List;

public interface AttractionDao {

    Attraction getById(Integer attrId);
    List<Attraction> getAll();
}
