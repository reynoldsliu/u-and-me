package tw.idv.cha102.g7.member.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.member.controller.exception.InsufficientPointsException;
import tw.idv.cha102.g7.member.dto.LoginDTO;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.MemberRepository;
import tw.idv.cha102.g7.member.service.MemberService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberController {


    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;


    /**
     * 會員註冊
     * @param member
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody Member member) {
        return memberService.insert(member);
    }



    /**
     * 會員登入
     * @param loginDTO
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO,
                                        HttpServletRequest request,
                                        HttpServletResponse response
    ) {
        memberService.login(loginDTO,request, response);
        return new ResponseEntity("登入成功",HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request,
                                        HttpServletResponse response
    ) {
        HttpSession session = request.getSession();
        String jsessionId = session.getAttribute("memberId").toString();
        if(jsessionId.isEmpty())
            return new ResponseEntity("登出失敗",HttpStatus.BAD_REQUEST);
        session.setAttribute("memberId",null);
//        if(session.getAttribute("memberId").toString()==null)
//            System.out.println("NULL");
        return new ResponseEntity("登出成功",HttpStatus.OK);
    }

    @RequestMapping("/testlogin")
    public ResponseEntity<String> testlogin(HttpServletRequest request,
                                            HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("memberId")==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        String sessionId = httpSession.getAttribute("memberId").toString(); // 保存目前登入的會員id，供後續使用
        System.out.println(sessionId);
        return new ResponseEntity<>(sessionId,HttpStatus.OK);
    }

    /**
     * 團主註冊
     * @param member
     * @return
     */
    @PostMapping("/groupRegister")
    public ResponseEntity<String> groupRegister(@RequestBody Member member) {
        Integer memId = member.getMemId();
        String memPassword = member.getMemPassword();

        // 檢查用戶是否已登入
//        HttpSession httpSession = request.getSession();
//        String sessionId = httpSession.getAttribute("memberId").toString();
//        Integer memSta = memberService.getMemberStatus(memId, memPassword);
//        if (memSta == null || memSta == 0 || memSta == 2) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("請先登入");
//        }

        // 更新會員的團主狀態為 1（團主）
        member.setMemSta(1);
        member.setMemGroup(1);
        memberService.update(member);

        return ResponseEntity.ok("您已成功註冊為團主");
    }


    /**
     * 會員刪除
     * @param memId
     * @return
     */
    @DeleteMapping("/delete/{memId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer memId,
                                          HttpServletRequest request) {
        HttpSession session = request.getSession();
        String jsessionId = session.getAttribute("memberId").toString();
        if(jsessionId.isEmpty())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        try {
            memberService.deleteById(memId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    /**
     * 會員資料更新
     * @param member
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Member> update(@RequestBody Member member) {
//        System.out.println(memEmail);
//        String memEmail = member.getMemEmail();
//        Member temp = memberRepository.findByMemEmail(memEmail);
//        member.setMemId(temp.getMemId());
//        if(member.getMemGender()==null){
//            member.setMemGender(temp.getMemGender());
//        }
//        System.out.println(temp);
        Member updatedMember = memberService.update(member);
//        Member updatedMember2 = memberRepository.save(temp);
        if (updatedMember != null) {
            return ResponseEntity.ok(updatedMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * 信箱驗證
     * @param member
     * @return
     */
//    public Member sendEmailVerify(Member member) {
//
//    }




}
