package tw.idv.cha102.g7.group.dao.impl;

import tw.idv.cha102.g7.group.dao.GroupRepDao;
import tw.idv.cha102.g7.group.entity.GroupRep;
import tw.idv.cha102.g7.group.repository.GroupRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupRepDaoImpl implements GroupRepDao {
    @Autowired
    GroupRepRepository groupRepRepository;

    @Override
    public void insert(GroupRep groupRep) {
        groupRepRepository.save(groupRep);
    }

    @Override
    public void update(Integer groupRepId, GroupRep groupRep) {
        groupRep.setGroupRepId(groupRepId);
        groupRepRepository.save(groupRep);
    }

    @Override
    public void delete(Integer groupRepId) {
        groupRepRepository.deleteById(groupRepId);
    }

    @Override
    public GroupRep getGroupRepByGroupRepId(Integer groupRepId) {
        GroupRep groupRep = groupRepRepository.findById(groupRepId).orElse(null);
        return groupRep;
    }

    @Override
    public List<GroupRep> getAll() {
        List<GroupRep> list = (List<GroupRep>) groupRepRepository.findAll();
        return list;
    }
}
