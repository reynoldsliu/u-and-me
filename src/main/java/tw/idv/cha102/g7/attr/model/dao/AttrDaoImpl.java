package tw.idv.cha102.g7.attr.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.attr.AttrRepository;
import tw.idv.cha102.g7.attr.model.Attr;

import java.util.List;

@Component
public class AttrDaoImpl implements AttrDao{

    @Autowired
    private AttrRepository attrRepository;


    @Override
    public Attr getById(Integer attrId){
        Attr attr = attrRepository.findById(attrId).orElse(null);
        return attr;
    }

    @Override
    public List<Attr> getAll(){
        List<Attr> attrs = (List<Attr>) attrRepository.findAll();

        return attrs;
    }
}
