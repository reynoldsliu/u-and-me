package tw.idv.cha102.g7.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.customer.entity.CustomerQa;
import tw.idv.cha102.g7.customer.service.CustomerQaService;

import java.util.List;

@RestController
public class CustomerQaController {
    @Autowired
    private CustomerQaService service;


    //顯示全部的Q&A
    @GetMapping("/qas")
    public List<CustomerQa> findAll() {
        return service.findAllQA();
    }


    //新增QA，新增完跳回至qalist，尚未新增驗證。
    @PostMapping("/addqa")
    public void addQa(CustomerQa customerQa) {
        service.addQa(customerQa);
    }

    //跳轉至QA修改頁面，尚未成功
    @PutMapping("/updateQa/{qaId}")
    public void updateById (@PathVariable Integer qaId, @RequestBody CustomerQa customerQa){
        service.updateById(qaId,customerQa);
    }


    //以下尚未跟頁面連結，測試api皆成功
    //依據QA狀態查詢
    @GetMapping("/qastate/{qaState}")
    public List<CustomerQa> findByQaState(@PathVariable Integer qaState) {
        return service.findByQaState(qaState);
    }

    //依據QAID查詢
    @GetMapping("/qas/{qaId}")
    public CustomerQa findByQaId(@PathVariable Integer qaId) {
        return service.findByQaId(qaId);
    }

    //刪除QAID
    @DeleteMapping("/delqa/{qaId}")
    public void deleteById(Integer qaId) {
        service.deleteById(qaId);
    }

}
