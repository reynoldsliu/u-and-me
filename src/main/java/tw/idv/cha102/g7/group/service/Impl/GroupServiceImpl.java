package tw.idv.cha102.g7.group.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dto.GroupGroupPicDto;
import tw.idv.cha102.g7.group.dto.GroupRegFormDto;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.group.repo.GroupRepository;
import tw.idv.cha102.g7.group.service.GroupService;

import java.util.List;

@Component
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;


    public void insert(Group group) {
        groupRepository.save(group);
    }

    public void update(Integer groupId, Group group) {
        if (getGroupByGroupId(groupId) != null) {
            group.setGroupId(groupId);
            groupRepository.save(group);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer groupId) {
        groupRepository.deleteById(groupId);
    }

    public Group getGroupByGroupId(Integer groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    public List<Group> getAllPaged(int page, int size) {
        Page<Group> pageResult = groupRepository.findAll(
                PageRequest.of(page, //查詢的頁數 從0開始
                                size,//查詢的每頁筆數
                                Sort.by("groupSta").ascending())); //依造group_sta欄位升冪排序
//        可能會運用到的方法
//        pageResult.getNumberOfElements(); //本頁筆數
//        pageResult.getSize(); //每頁筆數
//        pageResult.getTotalElements(); //全部筆數
//        pageResult.getTotalPages(); //全部頁數

        List<Group> groupList = pageResult.getContent();
        return groupList;
    }

    @Override
    public List<Group> findByMemIdOrderByGroupStaDesc(Integer memId) {
        return groupRepository.findByMemIdOrderByGroupStaDesc(memId);
    }
//    public List<Group> getGroupsByMemId(Integer memId){
//        return groupRepository.findGroupsByMemId(memId);
//    }

    @Override
    public List<Group> findByThemeContaining(String keyword) {
        return groupRepository.findByThemeContaining(keyword);
    }

    @Override
    public List<Group> findGroupByGroupSta(Integer groupSta) {
        return groupRepository.findGroupByGroupSta(groupSta);
    }

    @Override
    public List<Group> findGroupByPaymentSta(Integer paymentSta) {
        return groupRepository.findGroupByPaymentSta(paymentSta);
    }

    @Override
    public List<GroupRegFormDto> findGroupRegFormDtoByGroupId(Integer groupId) {
        return groupRepository.findGroupRegFormDtoByGroupId(groupId);
    }

    @Override
    public List<GroupGroupPicDto> findGroupRegFormDtoByGroupIdOrderByGroupPicId(Integer groupId) {
        return groupRepository.findGroupRegFormDtoByGroupIdOrderByGroupPicId(groupId);
    }

}
