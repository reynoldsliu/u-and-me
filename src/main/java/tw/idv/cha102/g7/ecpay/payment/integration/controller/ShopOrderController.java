package tw.idv.cha102.g7.ecpay.payment.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.ecpay.payment.integration.service.ShopOrderService;

@RestController
@RequestMapping("/shopOrder")
@CrossOrigin
public class ShopOrderController {

    @Autowired
    ShopOrderService shopOrderService;

    @PostMapping("/shopCheckout/{ordId}")
    public ResponseEntity<String> shopCheckout(@PathVariable Integer ordId){

        String aioCheckOutAllForm = shopOrderService.shopCheckout(ordId);

        return ResponseEntity.ok().body(aioCheckOutAllForm);
    }

    @PostMapping("/getResponse")
    public void getResponse(){
    }
}
