package tw.idv.cha102.g7.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.member.controller.exception.InsufficientPointsException;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.MemberRepository;
import tw.idv.cha102.g7.member.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {


    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;


    @PostMapping("/register")
    public String register(@RequestBody Member member) {
        return memberService.insert(member);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Member member) {
        String memEmail = member.getMemEmail();
        String memPassword = member.getMemPassword();

        String loginResult = memberService.login(memEmail, memPassword);
        if ("您已登入團主狀態".equals(loginResult)) {
            return ResponseEntity.ok("您已登入團主狀態");
        } else if ("您已登入會員狀態".equals(loginResult)) {
            return ResponseEntity.ok("您已登入會員狀態");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入失敗");
        }
    }

    @PostMapping("/groupRegister")
    public ResponseEntity<String> groupRegister(@RequestBody Member member) {
        Integer memId = member.getMemId();
        String memPassword = member.getMemPassword();

        // 檢查用戶是否已登入
        Integer memSta = memberService.getMemberStatus(memId, memPassword);
        if (memSta == null || memSta == 0 || memSta == 2) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("請先登入");
        }

        // 更新會員的團主狀態為 1（團主）
        member.setMemSta(1);
        member.setMemGroup(1);
        memberService.update(member);

        return ResponseEntity.ok("您已成功註冊為團主");
    }
//    @PostMapping("/ReportStatus")
//    public ResponseEntity<String>ReportStatus(@RequestBody Member member){
//        Integer memId = member.getMemId();
//        String memPassword = member.getMemPassword();
//
//        //
//    }


    @DeleteMapping("/delete/{memId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer memId) {
        try {
            memberService.deleteById(memId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PostMapping("/update")

    public ResponseEntity<Member> update(@RequestBody Member member) {
        Member updatedMember = memberService.update(member);
        if (updatedMember != null) {
            return ResponseEntity.ok(updatedMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @PostMapping("/{memberId}/usePoints")
//    public ResponseEntity<String> usePoints(@PathVariable Integer memId, @RequestParam int pointsToUse) {
//        try {
//            memberService.usePoints(memId, pointsToUse);
//            return ResponseEntity.ok("Points used successfully");
//        } catch (InsufficientPointsException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient points");
//        }
//    }

//    @GetMapping("/{memId}grade")
//    public ResponseEntity<Member> viewMemberGrade(@PathVariable Integer memId) {
//        Member memberGrade = memberService.getmemGradeBymemId(memId);
//        if (memberGrade != null) {
//            return ResponseEntity.ok(memberGrade);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
