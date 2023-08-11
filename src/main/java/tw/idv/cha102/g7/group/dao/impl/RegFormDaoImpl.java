package tw.idv.cha102.g7.group.dao.impl;

import tw.idv.cha102.g7.group.dao.RegFormDao;
import tw.idv.cha102.g7.group.entity.RegForm;
import tw.idv.cha102.g7.group.repository.RegFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegFormDaoImpl implements RegFormDao {
    @Autowired
    RegFormRepository regFormRepository;
    @Override
    public void insert(RegForm regForm) {
        regFormRepository.save(regForm);
    }

    @Override
    public void update(Integer formId, RegForm regForm) {
        regForm.setFormId(formId);
        regFormRepository.save(regForm);
    }

    @Override
    public void delete(Integer formId) {
        regFormRepository.deleteById(formId);
    }

    @Override
    public RegForm getRegFormByFormId(Integer formId) {
        return regFormRepository.findById(formId).orElse(null);
    }

    @Override
    public List<RegForm> getAll() {
        return (List<RegForm>) regFormRepository.findAll();
    }
}
