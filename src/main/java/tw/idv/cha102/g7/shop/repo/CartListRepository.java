package tw.idv.cha102.g7.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.shop.entity.CartList;
import tw.idv.cha102.g7.shop.entity.CartListId;

import java.util.List;

@Repository
public interface CartListRepository extends JpaRepository<CartList, Integer> {
//    CartList findByMemIdAndProdId(Integer memId, Integer prodId);
//
//    CartList findByMemId(Integer memId);
//
//    CartList deleteById(Integer memId, Integer prodId);
//    因為CartListRepository拿不到cartList裡的memId，memId被包在cartListId裡，
//    所以在這裡參數都不能寫到memId，所以其實以上方法都不用寫，
//    在CartserviceImpl裡面使用繼承(原本預設的方法就好ex:findAll())
//    所以CartserviceImpl裡的方法可以先拿到全部的cartList再取CartList裡的東西，就可取到memId

}
