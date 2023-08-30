package tw.idv.cha102.g7.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.shop.entity.OrderDetail;
import tw.idv.cha102.g7.shop.entity.OrderDetailId;
import tw.idv.cha102.g7.shop.service.OrderDetailService;

import java.util.List;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/OrderDetail/{ordId}/{page}")
    List<OrderDetail> findAllByOrdId(@PathVariable Integer ordId,
                                     @PathVariable Integer page){
        return orderDetailService.findByIdOrdId(ordId, page);
    }
}
