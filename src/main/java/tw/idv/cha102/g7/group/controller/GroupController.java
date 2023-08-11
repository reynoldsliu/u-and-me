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

    @PutMapping("/group/{groupId}")
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

    @GetMapping("/group/all")
    public List<Group> getAll(){
        return groupService.getAll();
    }
}
