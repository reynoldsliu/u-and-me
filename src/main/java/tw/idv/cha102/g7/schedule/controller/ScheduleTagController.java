package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.schedule.controller.exception.ScheduleNotFoundException;
import tw.idv.cha102.g7.schedule.dto.TagsInScheduleDTO;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.dto.TagToSchedulesDTO;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.List;

@RestController
@RequestMapping("/schTag")
public class ScheduleTagController {

    @Autowired
    private ScheduleTagService service;

    @GetMapping("/")
    public List<ScheduleTag> finaAllTag() {
        return service.findAll();
    }

    @GetMapping("/id/{schTagId}")
    public ScheduleTag findById(@PathVariable Integer schTagId) {
        return service.findById(schTagId);
    }

    @GetMapping("/name/{schTagName}")
    public List<ScheduleTag> findByName(@PathVariable String schTagName) {
        return service.findByName(schTagName);
    }

    @GetMapping("/DTOid/{schTagId}")
    public TagToSchedulesDTO findSchedules(@PathVariable Integer schTagId) {
        return service.findSchedulesBySchTagId(schTagId);
    }

    // 藉由行程標籤名字找出對應行程(待改寫)
    @GetMapping("/DTOname/{schTagName}")
    public List<TagToSchedulesDTO> findSchedulesByTagName(@PathVariable String schTagName) {
        return service.findSchedulesBySchTagName(schTagName);
    }

    // 藉由行程id找出對應行程標籤
    @GetMapping("/schId/{schId}")
    public List<ScheduleTag> findTagsBySchId(@PathVariable Integer schId) {
        return service.findTagsBySchId(schId);
    }

    /**
     * @param tag 行程標籤
     * @return 新增的行程標籤本身
     */
    @PostMapping("/add")
    public ResponseEntity<?> createTag(@RequestBody ScheduleTag tag) {
        return new ResponseEntity(service.createTag(tag),HttpStatus.OK);
    }

    /**
     * @param schTagId 行程標籤id
     * @return 新增的行程標籤本身
     */
    @RequestMapping("/delete/{schTagId}")
    public ResponseEntity<?> deleteTag(@PathVariable Integer schTagId){
        service.deleteTag(schTagId);
        return  new ResponseEntity("刪除成功！", HttpStatus.OK);
    }

}
