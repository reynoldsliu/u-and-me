package tw.idv.cha102.g7.group.dao;

import tw.idv.cha102.g7.group.entity.Group;

import java.util.List;

public interface GroupDao {
    void insert(Group group);
    void update(Integer groupId ,Group group);
    void delete(Integer groupId);
    Group getGroupByGroupId(Integer groupId);
    List<Group> getAll();
}
