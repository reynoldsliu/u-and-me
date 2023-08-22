package tw.idv.cha102.g7.group.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dto.GroupRegFormMemberDetailDto;
import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.group.repo.MemberDetailRepository;
import tw.idv.cha102.g7.group.service.MemberDetailService;

import java.util.List;

@Component
public class MemberDetailServiceImpl implements MemberDetailService {
    @Autowired
    MemberDetailRepository memberDetailRepository;

    public void insert(MemberDetail memberDetail){
        memberDetailRepository.save(memberDetail);
    }

    public void update(Integer detailId, MemberDetail memberDetail){
        if(getMemberDetailByDetailId(detailId) != null) {
            memberDetail.setDetailId(detailId);
            memberDetailRepository.save(memberDetail);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Integer detailId){
        memberDetailRepository.deleteById(detailId);
    }

    public MemberDetail getMemberDetailByDetailId(Integer detailId){
        return memberDetailRepository.findById(detailId).orElse(null);
    }

    public List<MemberDetail> getAll(){
        return memberDetailRepository.findAll();
    }

    @Override
    public List<MemberDetail> findByFormId(Integer formId) {
        return memberDetailRepository.findByFormId(formId);
    }

    @Override
    public List<GroupRegFormMemberDetailDto> findGroupRegFormMemberDetailDtoByGroupIdOrderByFormId(Integer groupId) {
        return memberDetailRepository.findGroupRegFormMemberDetailDtoByGroupIdOrderByFormId(groupId);
    }

    @Override
    public List<MemberDetail> findByRefundSta(Integer refundSta) {
        return memberDetailRepository.findByRefundSta(refundSta);
    }

    @Override
    public List<MemberDetail> findByMemId(Integer memId) {
        return memberDetailRepository.findByMemId(memId);
    }


}
