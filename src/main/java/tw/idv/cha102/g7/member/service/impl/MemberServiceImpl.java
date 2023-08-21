package tw.idv.cha102.g7.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.MemberRepository;
import tw.idv.cha102.g7.member.service.MemberService;

import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public void insert(Member member){
        memberRepository.save(member);
    }

    @Override
    public void deleteById(Integer memId){

        memberRepository.deleteById(memId);
    }

//    public Boolean login(Integer memId,String memPassword) {
//        return memberRepository.findById(memId).orElseThrow().getMemPassword().equals(memPassword);
//    }

    public String login(String memEmail, String memPassword) {
        Optional<Member> optionalMember = memberRepository.findByMemEmail(memEmail);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (member.getMemPassword().equals(memPassword)) {
                // 登入成功，檢查團主狀態
                if(member.getMemGroup() == 1){
                    return "您已登入團主狀態";
                }else{
                    return "您已登入會員狀態";
                }

            }
        }
        return "登入失敗";
    }

    public Integer getMemberStatus(Integer memId, String memPassword) {
        Optional<Member> optionalMember = memberRepository.findById(memId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (member.getMemPassword().equals(memPassword)) {
                return member.getMemSta();
            }
        }
        return null;
    }



    public Member update(Member member) {
        Member existingMember = memberRepository.findById(member.getMemId()).orElse(null);
        if (existingMember != null) {
            existingMember.setMemId(member.getMemId());
            existingMember.setMemEmail(member.getMemEmail());
            existingMember.setMemPassword(member.getMemPassword());
            existingMember.setMemSta(member.getMemSta());
            existingMember.setMemGroup(member.getMemGroup());


            return memberRepository.save(existingMember);
        }
        return null;
    }


    public Member getMemberByEmail(String memEmail) {
        return memberRepository.findByMemEmail(memEmail).orElse(null);
    }
//會員等級查看

//    public Member getmemGradeBymemId(Integer memId) {
//        return memberRepository.findMemberLevelById(memId);
//    }

}



