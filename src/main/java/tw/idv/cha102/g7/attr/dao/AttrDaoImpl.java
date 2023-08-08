package tw.idv.cha102.g7.attr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tw.idv.cha102.g7.attr.Attr;
import tw.idv.cha102.g7.attr.AttrRepository;

@Component
public class AttrDaoImpl implements AttrDao{

    @Autowired
    private AttrRepository attrRepository;


    @Override
    public Attr getById(Integer attrId){
        Attr attr = attrRepository.findById(attrId).orElse(null);
        return attr;
    }
}
