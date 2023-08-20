package tw.idv.cha102.g7.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.shop.entity.CartList;
import tw.idv.cha102.g7.shop.service.CartService;

import java.util.List;

@RestController
public class CartListController {

    @Autowired
    private CartService cartService;

    @GetMapping("/showAllCartList/{memId}")
    public List<CartList> showAllCartList(@PathVariable Integer memId) {
        return cartService.getAllCartList(memId);
    }
}
