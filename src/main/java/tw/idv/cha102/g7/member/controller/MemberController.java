package tw.idv.cha102.g7.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tw.idv.cha102.g7.member.MemberRepository;
import tw.idv.cha102.g7.member.model.Member;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/login")
    public String login(@ModelAttribute Member memberAccountJPA){

        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute Member member){
        System.out.println(memberRepository.findCheckMemberAccount(member.getEmail(), member.getPassword()));

        return "welcome";
    }
}
