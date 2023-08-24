package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.entity.RegForm;
import tw.idv.cha102.g7.group.service.RegFormService;

import java.util.List;

@RestController
@CrossOrigin
public class RegFormController {

    @Autowired
    private RegFormService regFormService;

    /**
     * 一般使用者
     * 新增報名表
     * @param regForm 欲新增的報名表
     */
    @PostMapping("/regForm")//新增報名表
    public void insert(@RequestBody RegForm regForm){
        regFormService.insert(regForm);
    }

    /**
     * 管理員
     * 修改報名表
     * @param formId 報名表ID
     * @param regForm 修改後的報名表資料
     */
    @PutMapping("/regForm/{formId}")//修改報名表
    public void update(@PathVariable Integer formId,
                       @RequestBody RegForm regForm){
        regFormService.update(formId, regForm);
    }

    /**
     * 管理員
     * 刪除報名表
     * @param formId 報名表ID
     */
    @DeleteMapping("/regForm/{formId}")//刪除報名表
    public void delete(@PathVariable Integer formId){
        regFormService.delete(formId);
    }

    /**
     * 一般使用者
     * 查詢報名表紀錄
     * @param memId 使用者ID
     * @return 所有報名表資料
     */
    @GetMapping("/regFormsMem/{memId}")//以memId查詢List報名表以報名時間排序
    List<RegForm> findByMemIdOrderByRegTime(@PathVariable Integer memId){
        return regFormService.findByMemIdOrderByRegTime(memId);
    }

    /**
     * 管理員
     * 查詢個別報名表
     * @param formId 報名表ID
     * @return 查詢資料
     */
    @GetMapping("/regForm/{formId}")//查詢個別報名表
    public RegForm getRegFormByFormId(@PathVariable Integer formId){
        return regFormService.getRegFormByFormId(formId);
    }

    /**
     * 揪團團主/管理員
     * 以揪團編號查詢報名表資料
     * @param groupId 揪團ID
     * @return 所有報名過的報名表資料
     */
    @GetMapping("/regFormsGroup/{groupId}")
    public List<RegForm> findByGroupIdOrderByRegTime(@PathVariable Integer groupId){
        return regFormService.findByGroupIdOrderByRegTime(groupId);
    }

    /**
     * 尋找用處中...
     * @return
     */
    @GetMapping("/regForms/all")
    public List<RegForm> getAll(){
        return regFormService.getAll();
    }
}
