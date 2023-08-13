package tw.idv.cha102.g7.attraction.service.impl;

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
        return attractionRepository.getById(attrId);
    }

    @Override
    public List<Attraction> getAll() {
        return attractionRepository.findAll();
    }
}
