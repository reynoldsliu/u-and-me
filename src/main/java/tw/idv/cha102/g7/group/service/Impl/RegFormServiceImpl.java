package tw.idv.cha102.g7.group.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.entity.RegForm;
import tw.idv.cha102.g7.group.repo.RegFormRepository;
import tw.idv.cha102.g7.group.service.RegFormService;

import java.util.List;

@Component
public class RegFormServiceImpl implements RegFormService {
    @Autowired
    RegFormRepository regFormRepository;

    public void insert(RegForm regForm){
        regFormRepository.save(regForm);
    }

    public void update(Integer formId, RegForm regForm){
        if(getRegFormByFormId(formId) != null) {
            regForm.setFormId(formId);
            regFormRepository.save(regForm);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer formId){
        regFormRepository.deleteById(formId);
    }

    public RegForm getRegFormByFormId(Integer formId){
        return regFormRepository.findById(formId).orElse(null);
    }

    public List<RegForm> getAll(){
        return regFormRepository.findAll();
    }

    @Override
    public List<RegForm> findByMemIdOrderByRegTime(Integer memId) {
        return regFormRepository.findByMemIdOrderByRegTime(memId);
    }

    @Override
    public List<RegForm> findByGroupIdOrderByRegTime(Integer groupId) {
        return regFormRepository.findByGroupIdOrderByRegTime(groupId);
    }
}
