package tw.idv.cha102.g7.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.member.entity.Host;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.HostRepository;

import tw.idv.cha102.g7.member.service.HostService;


import java.util.List;

@RestController
@RequestMapping("/host")
public class HostController {



    @Autowired
    private HostService hostService;

    @Autowired
    private HostRepository hostRepository;


    /**
     * 管理員註冊
     * @param host
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody Host host) {
        return hostService.insert(host);
    }

    /**
     * 管理員登入
     * @param host
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Host host) {
        String hostEmail = host.getHostEmail();
        String hostPassword = host.getHostPassword();

        String loginResult = hostService.login(hostEmail, hostPassword);
        if ("您已成功登入管理員系統".equals(loginResult)) {
            return ResponseEntity.ok("您已成功登入管理員系統");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入失敗");
        }
    }

    /**
     * 刪除管理員
     * (By hostId)
     * @param hostId
     * @return
     */
    @DeleteMapping("/delete/{hostId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer hostId) {
        try {
            hostService.deleteById(hostId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    /**
     * 更新管理員資料
     * @param host
     * @return
     */
    @PostMapping("/update")

    public ResponseEntity<Host> update(@RequestBody Host host) {
        Host updatedMember = hostService.update(host);
        if (updatedMember != null) {
            return ResponseEntity.ok(updatedMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
