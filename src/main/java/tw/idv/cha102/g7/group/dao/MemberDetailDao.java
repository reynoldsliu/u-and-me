package tw.idv.cha102.g7.group.dao;

import tw.idv.cha102.g7.group.entity.MemberDetail;

import java.util.List;

public interface MemberDetailDao {
    void insert(MemberDetail memberDetail);
    void update(Integer detailId, MemberDetail memberDetail);
    void delete(Integer detailId);
    MemberDetail getMemberDetailBydetailId(Integer detailId);
    List<MemberDetail> getAll();
}
