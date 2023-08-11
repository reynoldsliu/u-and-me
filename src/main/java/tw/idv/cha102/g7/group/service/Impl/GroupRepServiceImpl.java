package tw.idv.cha102.g7.group.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dao.GroupRepDao;
import tw.idv.cha102.g7.group.entity.GroupRep;
import tw.idv.cha102.g7.group.service.GroupRepService;

import java.util.List;

@Component
public class GroupRepServiceImpl implements GroupRepService {

    @Autowired
    private GroupRepDao groupRepDAO;

    public void insert(GroupRep groupRep) {
        groupRepDAO.insert(groupRep);
    }

    public void update(Integer groupRepId, GroupRep groupRep) {
        if (getGroupRepByGroupRepId(groupRepId) != null) {
            groupRepDAO.update(groupRepId, groupRep);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer groupRepId) {
        groupRepDAO.delete(groupRepId);
    }


    public GroupRep getGroupRepByGroupRepId(Integer groupRepId) {
        return groupRepDAO.getGroupRepByGroupRepId(groupRepId);
    }

    public List<GroupRep> getAll() {
        return groupRepDAO.getAll();
    }

}
