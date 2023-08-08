package tw.idv.cha102.g7.attr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.attr.Attr;
import tw.idv.cha102.g7.attr.AttrRepository;
import tw.idv.cha102.g7.attr.dao.AttrDao;

@Component
public class AttrServiceImpl implements AttrService{

    @Autowired
    private AttrDao attrDao;

//    @Autowired
//    private AttrRepository attrRepository;

    @Override
    public Attr getById(Integer attrId) {
        return attrDao.getById(attrId);
    }
}
