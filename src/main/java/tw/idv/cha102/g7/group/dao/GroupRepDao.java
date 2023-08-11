package tw.idv.cha102.g7.group.dao;

import tw.idv.cha102.g7.group.entity.GroupRep;

import java.util.List;

public interface GroupRepDao {
    void insert(GroupRep groupRep);
    void update(Integer groupRepId, GroupRep groupRep);
    void delete(Integer groupRepId);
    GroupRep getGroupRepByGroupRepId(Integer groupRepId);
    List<GroupRep> getAll();
}
