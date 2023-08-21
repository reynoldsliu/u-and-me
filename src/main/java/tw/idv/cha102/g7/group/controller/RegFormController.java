package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.entity.RegForm;
import tw.idv.cha102.g7.group.service.RegFormService;

import java.util.List;

@RestController
public class RegFormController {

    @Autowired
    private RegFormService regFormService;

    @PostMapping("/regForm")//新增報名表
    public void insert(@RequestBody RegForm regForm){
        regFormService.insert(regForm);
    }

    @PutMapping("/regForm/{formId}")//修改報名表
    public void update(@PathVariable Integer formId,
                       @RequestBody RegForm regForm){
        regFormService.update(formId, regForm);
    }

    @DeleteMapping("/regForm/{formId}")//刪除報名表
    public void delete(@PathVariable Integer formId){
        regFormService.delete(formId);
    }


    @GetMapping("/regFormsMem/{memId}")//以memId查詢List報名表以報名時間排序
    List<RegForm> findByMemIdOrderByRegTime(@PathVariable Integer memId){
        return regFormService.findByMemIdOrderByRegTime(memId);
    }

    @GetMapping("/regForm/{formId}")//查詢個別報名表
    public RegForm getRegFormByFormId(@PathVariable Integer formId){
        return regFormService.getRegFormByFormId(formId);
    }

    @GetMapping("/regFormsGroup/{groupId}")//以groupId查List報名表 揪團團主/管理員用
    public List<RegForm> findByGroupIdOrderByRegTime(@PathVariable Integer groupId){
        return regFormService.findByGroupIdOrderByRegTime(groupId);
    }

    @GetMapping("/regForm/all")
    public List<RegForm> getAll(){
        return regFormService.getAll();
    }
}
