package tw.idv.cha102.g7.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.member.entity.Host;

@RestController
@RequestMapping("/hostToMember")
public class HostToMemberController {

//    @PostMapping("/memberStatus")
//        public ResponseEntity<String> setMemberStatus(@RequestBody Host host) {
//            Integer memId = host.getHostId();
//            String memPassword = member.getMemPassword();
//
//            // 檢查用戶是否已登入
//            Integer memSta = memberService.getMemberStatus(memId, memPassword);
//            if (memSta == null || memSta == 0 || memSta == 2) {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("請先登入");
//            }
//
//            // 更新會員的團主狀態為 1（團主）
//            member.setMemSta(1);
//            member.setMemGroup(1);
//            memberService.update(member);
//
//            return ResponseEntity.ok("您已成功註冊為團主");
//        }
    }
