package tw.idv.cha102.g7.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.customer.entity.CustomerQa;
import tw.idv.cha102.g7.customer.service.CustomerQaService;

import java.util.List;

@Controller
public class CustomerQaController {
    @Autowired
    private CustomerQaService service;


    //顯示全部的Q&A
    @GetMapping("/qas")
    public String findAll(Model model) {

        List<CustomerQa> qas = service.findAllQA();
        model.addAttribute("qas",qas);

        return "/qa/qalist"; //待確認頁面路徑待修改，測試用。
    }

    //跳轉至新增QA專欄頁面
    @GetMapping("/qa")
    public String toAddpage(){
        return "/qa/addqa";
    }

    //新增QA，新增完跳回至qalist，尚未新增驗證。
    @PostMapping("/qa")
    public String addQa(CustomerQa customerQa) {
        service.addQa(customerQa);
        return "redirect:/qas"; //待確認頁面路徑待修改，測試用。
    }

    //跳轉至QA修改頁面，尚未成功
    @GetMapping("/qa/{qaId}")
    public  String toUpdateQa(@PathVariable Integer qaId, Model model){
        CustomerQa qa = service.findByQaId(qaId);
        model.addAttribute("qa",qa);
        return "qa/updateqa"; //頁面路徑待修改，測試用。
    }

    //待修改，尚未成功
    @PutMapping("/updateQa")
    public String updateById(CustomerQa customerQa) {
        return "redirect:/qas"; //頁面路徑待修改，測試用。
    }

    //以下尚未跟頁面連結，測試api皆成功
    //依據QA狀態查詢
    @ResponseBody
    @GetMapping("/qastate/{qaState}")
    public List<CustomerQa> findByQaState(@PathVariable Integer qaState) {
        return service.findByQaState(qaState);
    }

    //依據QAID查詢
    @ResponseBody
    @GetMapping("/qas/{qaId}")
    public CustomerQa findByQaId(@PathVariable Integer qaId) {
        return service.findByQaId(qaId);
    }

    //刪除QAID
    @ResponseBody
    @DeleteMapping("/delqa/{qaId}")
    public void deleteById(Integer qaId) {
        service.deleteById(qaId);
    }

}
