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

    @PostMapping("/groupPicture") //插入圖片
    public void insert(@RequestBody GroupPicture groupPicture){
        groupPictureService.insert(groupPicture);
    }

    @PutMapping("/groupPicture/{groupPicId}")//修改圖片
    public void update(@PathVariable Integer groupPicId,
                       @RequestBody GroupPicture groupPicture){
        groupPictureService.update(groupPicId ,groupPicture);
    }

    @DeleteMapping("/groupPicture/{groupPicId}")//刪除圖片
    public void delete(@PathVariable Integer groupPicId){
        groupPictureService.delete(groupPicId);
    }


    @GetMapping("groupPictures/{groupId}")//管理員以揪團查詢圖片
    public List<GroupPicture> findByGroupIdOrderByGroupPicId(@PathVariable Integer groupId) {
        return groupPictureService.findByGroupIdOrderByGroupPicId(groupId);
    }

    @GetMapping("/groupPicture/{groupPicId}")//管理員查詢指定圖片
    public GroupPicture getGroupPictureByGroupPicId(@PathVariable Integer groupPicId){
        return groupPictureService.getGroupPictureByGroupPicId(groupPicId);
    }

    @GetMapping("/groupPictures/all")//查詢全部圖片
    public List<GroupPicture> getAll(){
        return groupPictureService.getAll();
    }
}

