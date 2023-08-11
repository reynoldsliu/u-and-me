package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.group.service.MemberDetailService;

import java.util.List;

@RestController
public class MemberDetailController {
    @Autowired
    private MemberDetailService memberDetailService;

    @PostMapping("/memberDetail")
    public void insert(@RequestBody MemberDetail memberDetail){
        memberDetailService.insert(memberDetail);
    }

    @PutMapping("/memberDetail/{detailId}")
    public void update(@PathVariable Integer detailId,
                       @RequestBody MemberDetail memberDetail){
        memberDetailService.update(detailId, memberDetail);
    }

    @DeleteMapping("/memberDetail/{detailId}")
    public void delete(@PathVariable Integer detailId){
        memberDetailService.delete(detailId);
    }

    @GetMapping("/memberDetail/{detailId}")
    public MemberDetail getMemberDetailByDetailId(@PathVariable Integer detailId){
        return memberDetailService.getMemberDetailByDetailId(detailId);
    }

    @GetMapping("/memberDetail/all")
    public List<MemberDetail> getAll(){
        return memberDetailService.getAll();
    }
}
