package tw.idv.cha102.g7.group.service;

import tw.idv.cha102.g7.group.entity.Group;

import java.util.List;

public interface GroupService {
    void insert(Group group);

    void update(Integer groupId, Group group);

    void delete(Integer groupId);

    Group getGroupByGroupId(Integer groupId);

    List<Group> getAll();
}
