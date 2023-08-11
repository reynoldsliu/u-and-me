package tw.idv.cha102.g7.group.service.Impl;

import tw.idv.cha102.g7.group.dao.RegFormDao;
import tw.idv.cha102.g7.group.entity.RegForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.service.RegFormService;

import java.util.List;

@Component
public class RegFormServiceImpl implements RegFormService {
    @Autowired
    RegFormDao regFormDAO;

    public void insert(RegForm regForm){
        regFormDAO.insert(regForm);
    }

    public void update(Integer formId, RegForm regForm){
        if(getRegFormByFormId(formId) != null) {
            regFormDAO.update(formId, regForm);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer formId){
        regFormDAO.delete(formId);
    }

    public RegForm getRegFormByFormId(Integer formId){
        return regFormDAO.getRegFormByFormId(formId);
    }

    public List<RegForm> getAll(){
        return regFormDAO.getAll();
    }
}
