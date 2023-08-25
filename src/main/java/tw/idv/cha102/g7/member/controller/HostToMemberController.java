package tw.idv.cha102.g7.member.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.HostRepository;
import tw.idv.cha102.g7.member.repo.HostToMemberRepository;

import tw.idv.cha102.g7.member.repo.MemberRepository;
import tw.idv.cha102.g7.member.service.HostService;
import tw.idv.cha102.g7.member.service.HostToMemberService;
import tw.idv.cha102.g7.member.service.MemberDetailsService;
import tw.idv.cha102.g7.member.service.MemberService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hostToMember")
public class HostToMemberController {
    @Autowired
    private HostToMemberService hostToMemberService;
    @Autowired
    private HostService hostService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberDetailsService memberDetailsService;

    @Autowired
    private HostToMemberRepository hostToMemberRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private HostRepository hostRepository;



    @PostMapping("/memberStatus/{memEmail}/{sta}")
        public ResponseEntity<String> setMemberStatus(@PathVariable String memEmail,
                                                      @PathVariable Integer sta) {
//
            // 更新會員狀態(檢舉>>memSta 1 >> 2)
            Member member1 = hostToMemberService.getMemberByEmail(memEmail);
            member1.setMemSta(sta);
            memberService.update(member1);

            return ResponseEntity.ok("您已成功完成檢舉");
        }

    @PostMapping("/memberGroupStatus/{memEmail}/{sta}")
    public ResponseEntity<String> setMemberGroupSta(@PathVariable String memEmail,
                                                    @PathVariable Integer sta) {
//
        // 更新會員狀態(檢舉>>memSta 1 >> 2)
        Member member1 = hostToMemberService.getMemberByEmail(memEmail);
        member1.setMemSta(sta);
        memberService.update(member1);

        return ResponseEntity.ok("您已成功完成檢舉");
    }

    //管理員查詢全部會員

    @GetMapping("/all")
    public List<Member> getAll(){
        return memberDetailsService.getAll();
    }
}
