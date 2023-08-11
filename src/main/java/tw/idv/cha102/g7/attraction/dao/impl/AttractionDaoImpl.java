package tw.idv.cha102.g7.attraction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.attraction.AttractionRepository;
import tw.idv.cha102.g7.attraction.dao.AttractionDao;
import tw.idv.cha102.g7.attraction.vo.Attraction;

import java.util.List;

@Component
public class AttractionDaoImpl implements AttractionDao {

    @Autowired
    private AttractionRepository attractionRepository;


    @Override
    public Attraction getById(Integer attrId){
        Attraction attr = attractionRepository.findById(attrId).orElse(null);
        return attr;
    }

    @Override
    public List<Attraction> getAll(){
        List<Attraction> attrs = (List<Attraction>) attractionRepository.findAll();

        return attrs;
    }
}
