package tw.idv.cha102.g7.group.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dao.MemberDetailDao;
import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.group.service.MemberDetailService;

import java.util.List;

@Component
public class MemberDetailServiceImpl implements MemberDetailService {
    @Autowired
    MemberDetailDao memberDetailDAO;

    public void insert(MemberDetail memberDetail){
        memberDetailDAO.insert(memberDetail);
    }

    public void update(Integer detailId, MemberDetail memberDetail){
        if(getMemberDetailByDetailId(detailId) != null) {
            memberDetailDAO.update(detailId, memberDetail);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer detailId){
        memberDetailDAO.delete(detailId);
    }

    public MemberDetail getMemberDetailByDetailId(Integer detailId){
        return memberDetailDAO.getMemberDetailBydetailId(detailId);
    }

    public List<MemberDetail> getAll(){
        return memberDetailDAO.getAll();
    }
}
