package tw.idv.cha102.g7.group.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dto.RegFormMemberDetailDto;
import tw.idv.cha102.g7.group.dto.RegformIdDto;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.entity.RegForm;
import tw.idv.cha102.g7.group.repo.GroupRepository;
import tw.idv.cha102.g7.group.repo.RegFormRepository;
import tw.idv.cha102.g7.group.service.RegFormService;

import java.util.List;
import java.util.stream.Stream;

@Component
public class RegFormServiceImpl implements RegFormService {
    @Autowired
    RegFormRepository regFormRepository;

    @Autowired
    private GroupRepository groupRepository;

    public void insert(RegForm regForm){
        Group group = groupRepository.findById(regForm.getGroupId()).get();
        //如果參加人數小於最大人數才新增
        if(group.getMembers() + regForm.getJoinMember() <= group.getMaxMember()){
            regFormRepository.save(regForm);

            //將參與人數新增至group的參團人數
            group.setMembers(group.getMembers() + regForm.getJoinMember());
            groupRepository.save(group);
        }



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

    @Override
    public RegformIdDto findFormId() {
        return regFormRepository.findFormId();
    }

    @Override
    public Stream<RegFormMemberDetailDto> findRegFormMemberDetailDtoByGroupId(Integer groupId, Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "reg_time");
        Pageable pageable = PageRequest.of(page, 10, sort);
        return regFormRepository.findRegFormMemberDetailDtoByGroupId(groupId, pageable).get();
    }

}
