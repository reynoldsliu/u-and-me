package tw.idv.cha102.g7.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.member.entity.Host;
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


    @PostMapping("/register")
    public String register(@RequestBody Host host){
        hostService.insert(host);
        return "success";
    }

    @PostMapping("/login")
    public String login(@RequestBody Host host) {
        Integer hostId = host.getHostId();
        String memPassword = host.getHostPassword();
        String str = "failed";
//        Integer id = Integer.parseInt(memId);
        if(hostService.login(hostId,memPassword))
        {
            str = "success";
        }
        return str;
    }

    @DeleteMapping("/delete/{hostId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer hostId) {
        try {
            hostService.deleteById(hostId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    @PostMapping("/update")

    public ResponseEntity<Host> updateMember(@RequestBody Host host) {
        Host updatedMember = hostService.update(host);
        if (updatedMember != null) {
            return ResponseEntity.ok(updatedMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
