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

    @PostMapping("/regForm")
    public void insert(@RequestBody RegForm regForm){
        regFormService.insert(regForm);
    }

    @PutMapping("/regForm/{formId}")
    public void update(@PathVariable Integer formId,
                       @RequestBody RegForm regForm){
        regFormService.update(formId, regForm);
    }

    @DeleteMapping("/regForm/{formId}")
    public void delete(@PathVariable Integer formId){
        regFormService.delete(formId);
    }

    @GetMapping("/regForm/{formId}")
    public RegForm getRegFormByFormId(@PathVariable Integer formId){
        return regFormService.getRegFormByFormId(formId);
    }

    @GetMapping("/regForm/all")
    public List<RegForm> getAll(){
        return regFormService.getAll();
    }
}
