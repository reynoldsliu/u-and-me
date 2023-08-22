package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.dto.GroupRegFormMemberDetailDto;
import tw.idv.cha102.g7.group.entity.MemberDetail;
import tw.idv.cha102.g7.group.service.MemberDetailService;

import java.util.List;

@RestController
public class MemberDetailController {
    @Autowired
    private MemberDetailService memberDetailService;

    @PostMapping("/memberDetail")//新增報名細節
    public void insert(@RequestBody MemberDetail memberDetail){
        memberDetailService.insert(memberDetail);
    }

    //查List報名細節order by refundSta;
    @PutMapping("/memberDetail/{detailId}")//修改報名細節資料 //退費資訊
    public void update(@PathVariable Integer detailId,
                       @RequestBody MemberDetail memberDetail){
        memberDetailService.update(detailId, memberDetail);
    }

    @DeleteMapping("/memberDetail/{detailId}")//刪除報名細節
    public void delete(@PathVariable Integer detailId){
        memberDetailService.delete(detailId);
    }

    @GetMapping("/memberDetail/{detailId}")//查詢報名細節
    public MemberDetail getMemberDetailByDetailId(@PathVariable Integer detailId){
        return memberDetailService.getMemberDetailByDetailId(detailId);
    }


    @GetMapping("/memberDetailsGroupId/{groupId}")//以groupId查詢全部報名細節
    List<GroupRegFormMemberDetailDto> findGroupRegFormMemberDetailDtoByGroupIdOrderByFormId(@PathVariable Integer groupId){
        return memberDetailService.findGroupRegFormMemberDetailDtoByGroupIdOrderByFormId(groupId);
    }


    @GetMapping("/memberDetailsFormId/{formId}")//以formId查詢全部報名細節
    List<MemberDetail> findByFormId(@PathVariable Integer formId){
        return memberDetailService.findByFormId(formId);
    }

    @GetMapping("/memberDetailsAll")//查詢全部報名細節
    public List<MemberDetail> getAll(){
        return memberDetailService.getAll();
    }


}
