package tw.idv.cha102.g7.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.MemberRepository;
import tw.idv.cha102.g7.member.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
//    private EmailVerificationRepository emailVerificationRepository;

    /**
     * 新增
     *
     * @param member
     */
    @Override
    public String insert(Member member) {
        if (memberRepository.findByMemEmail(member.getMemEmail()) == null) {
            member.setMemSta(0);
            member.setMemGroup(0);
            memberRepository.save(member);
            return "您已成功註冊";
        } else {
            return "此Email已註冊過，請使用其他信箱!";
        }
    }

    @Override
    public void deleteById(Integer memId) {

        memberRepository.deleteById(memId);
    }

//    public Boolean login(Integer memId,String memPassword) {
//        return memberRepository.findById(memId).orElseThrow().getMemPassword().equals(memPassword);
//    }

    @Override
    public String login(String memEmail, String memPassword) {
        Member member = memberRepository.findByMemEmail(memEmail);
//        System.out.println(member.toString());
        if (member.getMemPassword().equals(memPassword)) {
            // 登入成功，檢查團主狀態
            if (member.getMemGroup() == 1) {
                return "您已登入團主狀態";
            } else {
                return "您已登入會員狀態";
            }
        }
        return "登入失敗";
    }

    @Override
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

    @Override
    public Member update(Member member) {
        String memEmail = member.getMemEmail();
        Member existingMember = memberRepository.findByMemEmail(memEmail);
//        Member existingMember = memberRepository.findById(member.getMemId()).orElse(null);
        System.out.println("member:" + member);
        if (existingMember != null) {
        if(member.getMemAddr()!=null){
            existingMember.setMemAddr(member.getMemAddr());
        }if(member.getMemPhone()!=null){
            existingMember.setMemPhone(member.getMemPhone());
        }if(member.getMemName()!=null){
            existingMember.setMemPhone(member.getMemName());
        }if(member.getMemPassword()!=null){
            existingMember.setMemPhone(member.getMemPassword());
        }
//        if (existingMember != null) {
//            existingMember.setMemId(member.getMemId());
//            existingMember.setMemEmail(member.getMemEmail());
//            existingMember.setMemPassword(member.getMemPassword());
//            existingMember.setMemName(member.getMemName());
//            existingMember.setMemGender(member.getMemGender());
//            existingMember.setMemAddr(member.getMemAddr());
//            existingMember.setMemPhone(member.getMemPhone());
//            existingMember.setMemSta(member.getMemSta());
//            existingMember.setMemGroup(member.getMemGroup());


            System.out.println("existingMember" + existingMember);
            return memberRepository.save(existingMember);
        }
        return null;
    }

    @Override
    public Member getMemByMemId(Integer memId) {
        return memberRepository.findById(memId).orElse(null);
    }


}



