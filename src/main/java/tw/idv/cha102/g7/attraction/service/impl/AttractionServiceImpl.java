package tw.idv.cha102.g7.attraction.service.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.attraction.service.AttractionService;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.attraction.repo.AttractionRepository;

import java.util.List;

@Component
public class AttractionServiceImpl implements AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;

    @Override
    public Attraction getById(Integer attrId) {

        return attractionRepository.findById(attrId).orElse(null);
    }

    @Override
    public List<Attraction> getAll() {
        return attractionRepository.findAll();
    }

    @Override
    public void setSta(Integer attrId, Short attrSta) {
        Attraction attraction = attractionRepository.getById(attrId);
        attraction.setSta(attrSta);
        attractionRepository.save(attraction);
    }

    @Override
    public String createAttr(Attraction attraction) {
        if(attractionRepository.getById(attraction.getId())!=null){
            return "Existed Attraction";
        }
        else{
            attractionRepository.save(attraction);
        }
        return "Create Attraction Success";
    }
}
