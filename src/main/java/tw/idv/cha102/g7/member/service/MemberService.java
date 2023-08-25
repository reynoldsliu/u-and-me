package tw.idv.cha102.g7.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.MemberRepository;

import java.util.List;


public interface MemberService {
/////會員登入相關/////

    //會員註冊
    public String insert(Member member);

    //會員登入驗證(信箱驗證)
//    public void verifyEmail(String token);

    //會員登入
    public String login(String memEmail,String memPassword);

    //會員刪除
    public void deleteById(Integer memId);

    //會員資料修改
    public Member update(Member member);

    //會員狀態更新(團主狀態更新/會員檢舉狀態更新)
    public Integer getMemberStatus(Integer memId, String memPassword);


//    public Member getMemberByEmail(String memEmail);

//    public void usePoints(Integer memId, int pointsToUse);
    }








