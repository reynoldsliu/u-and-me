package tw.idv.cha102.g7.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.MemberRepository;

import java.util.List;

public interface MemberService {

    public void insert(Member member);
    public void deleteById(Integer memId);
    public String login(Integer memId,String memPassword);
    public Member update(Member member);
    public Integer getMemberStatus(Integer memId, String memPassword);
}

