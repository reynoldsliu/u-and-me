package tw.idv.cha102.g7.group.service.Impl;


import org.hibernate.loader.plan.build.spi.ReturnGraphTreePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.entity.Group;
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

    public List<Group> getAll() {
        return (List<Group>) groupRepository.findAll();
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
}
