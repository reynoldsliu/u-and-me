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

    @PostMapping("/groupRep")
    public void insert(@RequestBody GroupRep groupRep){
        groupRepService.insert(groupRep);
    }

    @PutMapping("/groupRep/{groupRepId}")
    public void update(@PathVariable Integer groupRepId,
                       @RequestBody GroupRep groupRep){
        groupRepService.update(groupRepId, groupRep);
    }

    @DeleteMapping("/groupRep/{groupRepId}")
    public void delete(@PathVariable Integer groupRepId){
        groupRepService.delete(groupRepId);
    }

    @GetMapping("/groupRep/{groupRepId}")
    public GroupRep getGroupReqByGroupRepId(@PathVariable Integer groupRepId){
        return groupRepService.getGroupRepByGroupRepId(groupRepId);
    }

    @GetMapping("/groupRep/all")
    public List<GroupRep> getAll(){
        return groupRepService.getAll();
    }
}
