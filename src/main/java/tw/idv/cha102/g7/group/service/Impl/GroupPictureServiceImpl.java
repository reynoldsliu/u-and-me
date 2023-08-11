package tw.idv.cha102.g7.group.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dao.GroupPictureDao;
import tw.idv.cha102.g7.group.entity.GroupPicture;
import tw.idv.cha102.g7.group.service.GroupPictureService;

import java.util.List;

@Component
public class GroupPictureServiceImpl implements GroupPictureService {

    @Autowired
    GroupPictureDao groupPictureDAO;

    public void insert(GroupPicture groupPicture) {
        groupPictureDAO.insert(groupPicture);
    }

    public void update(Integer groupPicId, GroupPicture groupPicture) {
        if (getGroupPictureByGroupPicId(groupPicId) != null) {
            groupPictureDAO.update(groupPicId, groupPicture);
        }
    }

    public void delete(Integer groupPicId){
        groupPictureDAO.delete(groupPicId);
    }

    public GroupPicture getGroupPictureByGroupPicId(Integer groupPicId){
        return groupPictureDAO.getGroupPictureByGroupPicId(groupPicId);
    }

    public List<GroupPicture> getAll(){
        return groupPictureDAO.getAll();
    }
}
