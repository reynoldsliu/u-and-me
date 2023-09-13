package tw.idv.cha102.g7.shop.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.cha102.g7.shop.dto.MaxOrdIdDTO;
import tw.idv.cha102.g7.shop.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Page<Orders> findByMemId(Integer memId, Pageable pageable);

    @Query(value = "select Max(ord_id) as maxOrdId from orders", nativeQuery = true)
    MaxOrdIdDTO findMaxId();
}
