package tw.idv.cha102.g7.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.member.repo.MemberRepository;
import tw.idv.cha102.g7.shop.entity.CartList;
import tw.idv.cha102.g7.shop.entity.Order;
import tw.idv.cha102.g7.shop.repo.CartListRepository;
import tw.idv.cha102.g7.shop.repo.OrderRepository;
import tw.idv.cha102.g7.shop.service.CartService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartListRepository cartListRepository;
    @Autowired
    private OrderRepository orderRepository;

//        @Autowired
//        public CartServiceImpl(CartListRepository cartListRepository, OrderRepository orderRepository) {
//            this.cartListRepository = cartListRepository;
//            this.orderRepository = orderRepository;
//        }
//
//        @Override
//        //新增購物車項目
//        public CartList addToCart(Integer memId, Integer prodId, Integer cartPri, Integer cartQty) {
////            // 根據會員ID和商品ID查詢購物車項目
//            CartList cartList = cartListRepository.findByMemIdAndProdId(memId, prodId);
//
//            if (cartList == null) {
//                // 若購物車項目不存在，創建新的項目並設定相關資訊
//                cartList = new CartList();
////                cartList.setMemId(memId);
////                cartList.setProdId(prodId);
//                  cartList.setCartQty(cartQty);
//                  cartList.setCartPri(cartPri);
//            } else {
//                // 若購物車項目存在，更新數量
//                cartList.setCartQty(cartList.getCartQty() + cartQty);
//            }
//
//            // 儲存或更新購物車項目
//            return cartListRepository.save(cartList);
//        }
//

        //查看購物車項目: 先把cartList全部列出，如果對應到的memId=裡面的memId就被取出來
        @Override
        public List<CartList> getAllCartList(Integer memId){
            List<CartList> allList = cartListRepository.findAll();
            List<CartList> returnList = new ArrayList<>();
            for(CartList cartlist: allList){
                if(cartlist.getCartListId().getMemId() == memId){
                    returnList.add(cartlist);
                }
            }
            return returnList;
        }
//        @Override
//        public void deleteById(Integer memId, Integer prodId) {
//            cartListRepository.deleteById(memId, prodId);
//        }
////
//        //更新一筆購物車數量
//        public CartList updateCartQty(Integer memId, Integer prodId, Integer cartQty) {
//            CartList cartList = cartListRepository.findByMemIdAndProdId(memId, prodId);
//            if (cartList != null) {
//                cartList.setCartQty(cartQty);
//                cartListRepository.save(cartList);
//
//
//            }
//        }


//    @Override
//    public Order checkoutWithCash(Integer memId) {
//        // 根據購物車內容創建訂單
//        Order order = new Order();
//        order.setMemId(memId);
//        // 設置其他訂單相關信息
//        // ...
//
//        // 設置支付方式為 "貨到付款"
//        order.setPaymentMethod("Cash On Delivery");
//
//        // 保存訂單到數據庫
//        return orderRepository.save(order);
    }



