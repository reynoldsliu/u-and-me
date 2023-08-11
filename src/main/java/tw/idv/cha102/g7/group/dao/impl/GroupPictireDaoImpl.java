package tw.idv.cha102.g7.group.dao.impl;

import tw.idv.cha102.g7.group.dao.GroupPictureDao;
import tw.idv.cha102.g7.group.entity.GroupPicture;
import tw.idv.cha102.g7.group.repository.GroupPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupPictireDaoImpl implements GroupPictureDao {
    @Autowired
    private GroupPictureRepository groupPictureRepository;

    @Override
    public void insert(GroupPicture groupPicture) {
        groupPictureRepository.save(groupPicture);
    }

    @Override
    public void update(Integer groupPicId, GroupPicture groupPicture) {
        groupPicture.setGroupId(groupPicId);
        groupPictureRepository.save(groupPicture);
    }

    @Override
    public void delete(Integer groupPicId) {
        groupPictureRepository.deleteById(groupPicId);
    }

    @Override
    public GroupPicture getGroupPictureByGroupPicId(Integer groupPicId) {
        GroupPicture groupPicture = groupPictureRepository.findById(groupPicId).orElse(null);
        return groupPicture;
    }

    @Override
    public List<GroupPicture> getAll() {
        List<GroupPicture> list = (List<GroupPicture>) groupPictureRepository.findAll();
        return list;
    }
}
