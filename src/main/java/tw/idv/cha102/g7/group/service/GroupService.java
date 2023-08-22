package tw.idv.cha102.g7.group.service;

import tw.idv.cha102.g7.group.dto.GroupGroupPicDto;
import tw.idv.cha102.g7.group.dto.GroupRegFormDto;
import tw.idv.cha102.g7.group.entity.Group;

import java.util.List;

public interface GroupService {
    void insert(Group group);

    void update(Integer groupId, Group group);

    void delete(Integer groupId);

    Group getGroupByGroupId(Integer groupId);

    List<Group> getAllPaged(int page, int size);

    List<Group> findByMemIdOrderByGroupStaDesc(Integer memId);
//    List<Group> getGroupsByMemId(Integer memId);
    List<Group> findByThemeContaining(String keyword);

    List<Group> findGroupByGroupSta(Integer groupSta);

    List<Group> findGroupByPaymentSta(Integer paymentSta);

    List<GroupRegFormDto> findGroupRegFormDtoByGroupId(Integer groupId);

    List<GroupGroupPicDto> findGroupRegFormDtoByGroupIdOrderByGroupPicId(Integer groupId);


}
