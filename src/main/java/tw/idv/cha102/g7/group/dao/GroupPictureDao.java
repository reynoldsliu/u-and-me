package tw.idv.cha102.g7.group.dao;

import tw.idv.cha102.g7.group.entity.GroupPicture;

import java.util.List;

public interface GroupPictureDao {
    void insert(GroupPicture groupPicture);
    void update(Integer groupPicId, GroupPicture groupPicture);
    void delete(Integer groupPicId);
    GroupPicture getGroupPictureByGroupPicId(Integer groupPicId);
    List<GroupPicture> getAll();
}
