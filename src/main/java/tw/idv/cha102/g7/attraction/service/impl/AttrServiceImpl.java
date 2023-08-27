package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.attraction.service.AttrService;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.attraction.repo.AttrRepository;
import tw.idv.cha102.g7.group.entity.Group;

import java.util.List;

@Component
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrRepository attrRepository;

    /**
    * 透過attrId去查詢一個景點
    * @param attrId Atraction的ID
    * @return 查詢到的Attraction，若沒查到則返回null
     */
    @Override
    public Attraction getById(Integer attrId) {
        return attrRepository.findById(attrId).orElse(null);
    }

    /**
     * 查詢全部的Attraction
     * @return List<Attraction>一組Attraction
     */
    @Override
    public List<Attraction> getAll() {
        return attrRepository.findAll();
    }

    @Override
    public void setSta(Integer attrId, Short attrSta) {
        Attraction attraction = attrRepository.getById(attrId);
        attraction.setAttrSta(attrSta);
        attrRepository.save(attraction);
    }

    @Override
    public List<Attraction> getAttrsByName(String attrName){
        return attrRepository.findAllByAttrNameContaining(attrName);
    }

    @Override
    public List<Attraction> getAllPaged(int page, int size) {
        Page<Attraction> pageResult = attrRepository.findAll(
                PageRequest.of(page, //查詢的頁數 從0開始
                        size,//查詢的每頁筆數
                        Sort.by("attrId").ascending())); //依造group_sta欄位升冪排序
//        可能會運用到的方法
//        pageResult.getNumberOfElements(); //本頁筆數
//        pageResult.getSize(); //每頁筆數
//        pageResult.getTotalElements(); //全部筆數
//        pageResult.getTotalPages(); //全部頁數

        List<Attraction> attrList = pageResult.getContent();
        return attrList;
    }

    @Override
    public Page<Attraction> getAllPagedByName(String attrName, int page, int size) {
        return attrRepository.findAllByAttrNameContaining(attrName, PageRequest.of(page, size));
    }

//    @Override
//    public String addAttrToCollection(Attraction attraction) {
//        attractionRepository.save(attraction).
//        return null;
//    }

    @Override
    public String createAttr(Attraction attraction) {
        if(attrRepository.getById(attraction.getAttrId())!=null){
            return "Existed Attraction";
        }
        else{
            attrRepository.save(attraction);
        }
        return "Create Attraction Success";
    }
}
