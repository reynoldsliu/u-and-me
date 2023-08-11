package tw.idv.cha102.g7.group.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dao.GroupDao;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.service.GroupService;

import java.util.List;

@Component
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDAO;

    public void insert(Group group){
        groupDAO.insert(group);
    }

    public void update(Integer groupId, Group group){
        if(getGroupByGroupId(groupId) != null) {
            groupDAO.update(groupId, group);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer groupId){
        groupDAO.delete(groupId);
    }

    public Group getGroupByGroupId(Integer groupId){
        return groupDAO.getGroupByGroupId(groupId);
    }

    public List<Group> getAll(){
        return groupDAO.getAll();
    }
}
