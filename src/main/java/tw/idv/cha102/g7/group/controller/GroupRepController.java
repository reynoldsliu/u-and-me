package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.entity.GroupRep;
import tw.idv.cha102.g7.group.service.GroupRepService;

import java.util.List;

@RestController
public class GroupRepController {

    @Autowired
    private GroupRepService groupRepService;

    @PostMapping("/groupRep") //檢舉揪團
    public void insert(@RequestBody GroupRep groupRep){
        groupRepService.insert(groupRep);
    }

    @PutMapping("/groupRep/{groupRepId}") //管理員修改檢舉狀態
    public void update(@PathVariable Integer groupRepId,
                       @RequestBody GroupRep groupRep){
        groupRepService.update(groupRepId, groupRep);
    }

    @DeleteMapping("/groupRep/{groupRepId}") //刪除檢舉
    public void delete(@PathVariable Integer groupRepId){
        groupRepService.delete(groupRepId);
    }


    @GetMapping("/groupRepsSta/{GroupRepSta}")//管理員查詢檢舉狀態GroupRepSta
    public List<GroupRep> findByGroupRepSta(@PathVariable Integer GroupRepSta) {
        return groupRepService.findByGroupRepSta(GroupRepSta);
    }

    @GetMapping("/groupRepsMemSta/{MemId}/{GroupRepSta}")//查詢檢舉的會員memId
    public List<GroupRep> findByMemIdAndGroupRepSta(@PathVariable Integer MemId,
                                                    @PathVariable Integer GroupRepSta) {
        return groupRepService.findByMemIdAndGroupRepSta(MemId, GroupRepSta);
    }

    @GetMapping("/groupRep/{groupRepId}") //好像沒用
    public GroupRep getGroupReqByGroupRepId(@PathVariable Integer groupRepId){
        return groupRepService.getGroupRepByGroupRepId(groupRepId);
    }

    @GetMapping("/groupRep/all") //查詢全部檢舉
    public List<GroupRep> getAll(){
        return groupRepService.getAll();
    }
}
