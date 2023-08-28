package tw.idv.cha102.g7.attraction.service;

import org.springframework.data.domain.Page;
import tw.idv.cha102.g7.attraction.entity.Attraction;

import java.util.List;

public interface AttrService {

    Attraction getById(Integer attrId);

    String createAttr(Attraction attraction);
    List<Attraction> getAll();

    void setSta(Integer attrId, Short attrSta);

    List<Attraction> getAttrsByName(String attrName);

    public List<Attraction> getAllPaged(int page, int size);

    //TRY PAGEABLE
    public Page<Attraction> getAllPagedByName(String attrName, int page, int size);

//    String addAttrToCollection(Attraction attraction);
}
