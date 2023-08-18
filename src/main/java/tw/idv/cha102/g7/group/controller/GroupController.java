package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.service.GroupService;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    public void insert(@RequestBody Group group){
        groupService.insert(group);
    }

    @PutMapping("/group/{groupId}") //管理員修改揪團狀態/支付狀態
    public void update(@PathVariable Integer groupId,
                       @RequestBody Group group){
        groupService.update(groupId, group);
    }

    @DeleteMapping("/group/{groupId}")
    public void delete(@PathVariable Integer groupId){
        groupService.delete(groupId);
    }

    @GetMapping("/group/{groupId}")
    public Group getGroupByGroupId(@PathVariable Integer groupId){
        return groupService.getGroupByGroupId(groupId);
    }

    @GetMapping("/groups/all") //查詢所有揪團
    public List<Group> getAll(){
        return groupService.getAll();
    }

    @GetMapping("/groups/findByMemId/{memId}") //揪團主找自己揪團
    public List<Group> findByMemIdOrderByGroupStaDesc(@PathVariable Integer memId){
        return groupService.findByMemIdOrderByGroupStaDesc(memId);
    }

//    @GetMapping("/groups/selectByMem{memId}")
//    public List<Group> getGroupsByMemId(@PathVariable Integer memId){
//        return groupService.getGroupsByMemId(memId);
//    }

    @GetMapping("/groups/searchTheme/{keyword}") //尋找揪團名稱
    public List<Group> findByThemeContaining(@PathVariable String keyword){
        return groupService.findByThemeContaining(keyword);
    }

    @GetMapping("/groups/searchSta/{groupSta}") //管理員尋找揪團狀態
    public List<Group> findGroupByGroupSta(@PathVariable Integer groupSta){
        return groupService.findGroupByGroupSta(groupSta);
    }

    @GetMapping("/groups/searchPaySta/{paymentSta}") //管理員尋找揪團付費
    public List<Group> findGroupByPaymentSta(@PathVariable Integer paymentSta){
        return groupService.findGroupByPaymentSta(paymentSta);
    }
}
