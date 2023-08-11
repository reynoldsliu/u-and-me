package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.entity.GroupPicture;
import tw.idv.cha102.g7.group.service.GroupPictureService;

import java.util.List;

@RestController
public class GroupPictureController {

    @Autowired
    private GroupPictureService groupPictureService;

    @PostMapping("/groupPicture")
    public void insert(@RequestBody GroupPicture groupPicture){
        groupPictureService.insert(groupPicture);
    }

    @PutMapping("/groupPicture/{groupPicId}")
    public void update(@PathVariable Integer groupPicId,
                       @RequestBody GroupPicture groupPicture){
        groupPictureService.update(groupPicId ,groupPicture);
    }

    @DeleteMapping("/groupPicture/{groupPicId}")
    public void delete(@PathVariable Integer groupPicId){
        groupPictureService.delete(groupPicId);
    }

    @GetMapping("/groupPicture/{groupPicId}")
    public GroupPicture getGroupPictureByGroupPicId(@PathVariable Integer groupPicId){
        return groupPictureService.getGroupPictureByGroupPicId(groupPicId);
    }

    @GetMapping("/groupPicture/all")
    public List<GroupPicture> getAll(){
        return groupPictureService.getAll();
    }
}

