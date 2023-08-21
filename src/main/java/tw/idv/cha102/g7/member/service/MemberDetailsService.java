package tw.idv.cha102.g7.member.service;

import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.member.entity.Member;

import java.util.List;

public interface MemberDetailsService {
    public Member getMemberByEmail(String memEmail);

    List<Member> getAll();

}
