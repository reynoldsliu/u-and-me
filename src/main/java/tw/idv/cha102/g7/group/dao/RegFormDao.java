package tw.idv.cha102.g7.group.dao;

import tw.idv.cha102.g7.group.entity.RegForm;

import java.util.List;

public interface RegFormDao {
    void insert(RegForm regForm);
    void update(Integer formId ,RegForm regForm);
    void delete(Integer formId);
    RegForm getRegFormByFormId(Integer formId);
    List<RegForm> getAll();
}
