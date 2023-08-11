package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.attraction.service.AttractionService;
import tw.idv.cha102.g7.attraction.vo.Attraction;
import tw.idv.cha102.g7.attraction.dao.AttractionDao;

import java.util.List;

@Component
public class AttractionServiceImpl implements AttractionService {

    @Autowired
    private AttractionDao attractionDao;

    @Override
    public Attraction getById(Integer attrId) {
        return attractionDao.getById(attrId);
    }

    @Override
    public List<Attraction> getAll() {
        return attractionDao.getAll();
    }
}
