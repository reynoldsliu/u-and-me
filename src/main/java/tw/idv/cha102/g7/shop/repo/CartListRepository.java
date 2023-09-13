package tw.idv.cha102.g7.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.shop.entity.CartList;
import tw.idv.cha102.g7.shop.entity.CartListId;

@Repository
public interface CartListRepository extends JpaRepository<CartList, Integer> {
    CartList findByCartListId_MemIdAndCartListId_ProdId(Integer memId, Integer prodId);

    //使用c.來代表CartList，:cartListId 是一個命名參數
    //使用@Param("cartListId")，將 cartListId 這個參數名綁定到JPQL中的 :cartListId。
    @Modifying
    @Query("DELETE FROM CartList c WHERE c.cartListId= :cartListId")
    void deleteByCartListId(@Param("cartListId") CartListId cartListId);


//    因為CartListRepository拿不到cartList裡的memId，memId被包在cartListId裡，
//    所以在這裡參數都不能寫到memId，所以其實以上方法都不用寫，
//    在CartserviceImpl裡面使用繼承(原本預設的方法就好ex:findAll())
//    所以CartserviceImpl裡的方法可以先拿到全部的cartList再取CartList裡的東西，就可取到memId


    @Modifying
    @Query(value = "DELETE FROM orders AS o LEFT JOIN order_detail AS od ON o.ord_id = od.ord_id LEFT JOIN product AS p ON od.prod_id = p.prod_id LEFT JOIN cart_list AS c ON c.prod_id = p.prod_id WHERE o.ordId = ?1", nativeQuery = true)
    void deleteCartListByOrdId(Integer ordId);
}
