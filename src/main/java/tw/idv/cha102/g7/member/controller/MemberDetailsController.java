package tw.idv.cha102.g7.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.member.repo.MemberRepository;
import tw.idv.cha102.g7.member.service.MemberDetailsService;
import tw.idv.cha102.g7.member.service.MemberService;
import tw.idv.cha102.g7.member.entity.Member;

import java.util.List;

@RestController
@RequestMapping("/memberDetails")
public class MemberDetailsController {
    @Autowired
    private MemberDetailsService memberDetailsService;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/{memEmail}")
    public ResponseEntity<Member> viewMemberProfile(@PathVariable String memEmail) {
        Member member = memberDetailsService.getMemberByEmail(memEmail);
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/Level/{memEmail}")
    public ResponseEntity<Member> viewMemberGrade(@PathVariable String memEmail) {
        Member member = memberDetailsService.getMemberByEmail(memEmail);
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/all")
    public List<Member> getAll(){
        return memberDetailsService.getAll();
    }
}

