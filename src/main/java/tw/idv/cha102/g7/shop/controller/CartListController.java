package tw.idv.cha102.g7.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.shop.entity.CartList;
import tw.idv.cha102.g7.shop.entity.CartListId;
import tw.idv.cha102.g7.shop.service.CartService;

import java.util.List;

@RestController
public class CartListController {

    @Autowired
    private CartService cartService;

    @Autowired
    public CartListController(CartService cartService) {
        this.cartService = cartService;
    }

    //用cartList取得cartListId實體變數
    //.getCartListId() 方法獲取複合主鍵對象，就可.getMemId()和.getProdId() 方法來獲取複合主鍵的成員屬性值
    @PostMapping("/addCartList")
    public CartList addCartList(@RequestBody CartList cartList){
        CartListId cartListId = cartList.getCartListId();
        Integer memId = cartListId.getMemId();
        Integer prodId = cartListId.getProdId();
        Integer cartPri = cartList.getCartPri();
        Integer cartQty = cartList.getCartQty();
        return cartService.addToCart(memId, prodId, cartPri, cartQty);
    }

    @GetMapping("/showAllCartList/{memId}")
    public List<CartList> showAllCartList(@PathVariable Integer memId) {
        return cartService.getAllCartList(memId);
    }

    @DeleteMapping("/deleteCartList/{memId}/{prodId}")
    public void deleteCartList(@PathVariable Integer memId,
                               @PathVariable Integer prodId){
        cartService.deleteById(memId, prodId);
    }

    @RequestMapping("/updateCartList/{memId}/{prodId}/{prodQty}")
    public CartList updateCartList(@PathVariable Integer memId,
                                   @PathVariable Integer prodId,
                                   @PathVariable Integer prodQty){
       return cartService.updateCartListQty(memId, prodId, prodQty);
    }
}
