package tw.idv.cha102.g7.group.dao.impl;

import tw.idv.cha102.g7.group.dao.GroupDao;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@RestController
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private GroupRepository groupRepository;

//    @PostMapping("/group")
    @Override
    public void insert(Group group) {
        groupRepository.save(group);
    }


//    @PutMapping("/group/{groupId}")
    @Override
    public void update(Integer groupId ,
                       Group group) {
        group.setGroupId(groupId);
        groupRepository.save(group);
    }

//    @DeleteMapping("/group/{groupId}")
    @Override
    public void delete(Integer groupId) {
        groupRepository.deleteById(groupId);
    }

//    @GetMapping("/group/{groupId}")
    @Override
    public Group getGroupByGroupId(Integer groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        return group;
    }

//    @GetMapping("/group/all")
    @Override
    public List<Group> getAll() {
        List<Group> list = (List<Group>) groupRepository.findAll();
        return list;
    }
}
