package tw.idv.cha102.g7.group.dao.impl;

import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dao.MemberDetailDao;
import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.group.repository.MemberDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class MemberDetailDaoImpl implements MemberDetailDao {

    @Autowired
    MemberDetailRepository memberDetailRepository;

    @Override
    public void insert(MemberDetail memberDetail) {
        memberDetailRepository.save(memberDetail);
    }

    @Override
    public void update(Integer detailId, MemberDetail memberDetail) {
        memberDetail.setDetailId(detailId);
        memberDetailRepository.save(memberDetail);
    }

    @Override
    public void delete(Integer detailId) {
        memberDetailRepository.deleteById(detailId);
    }

    @Override
    public MemberDetail getMemberDetailBydetailId(Integer detailId) {
        MemberDetail memberDetail = memberDetailRepository.findById(detailId).orElse(null);
        return memberDetail;
    }

    @Override
    public List<MemberDetail> getAll() {
        List<MemberDetail> list = (List<MemberDetail>) memberDetailRepository.findAll();
        return list;
    }
}
