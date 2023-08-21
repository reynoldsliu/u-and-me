package tw.idv.cha102.g7.group.service;

import tw.idv.cha102.g7.group.entity.RegForm;

import java.util.List;

public interface RegFormService {
    void insert(RegForm regForm);

    void update(Integer formId, RegForm regForm);

    void delete(Integer formId);

    RegForm getRegFormByFormId(Integer formId);

    List<RegForm> getAll();

    List<RegForm> findByMemIdOrderByRegTime(Integer memId);

    List<RegForm> findByGroupIdOrderByRegTime(Integer groupId);
}
