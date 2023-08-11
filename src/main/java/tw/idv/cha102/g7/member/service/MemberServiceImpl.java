package tw.idv.cha102.g7.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.member.model.dao.MemberDao;

@Component
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao memberDao;
}
