package tw.idv.cha102.g7.shop.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.shop.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Page<Orders> findByMemId(Integer memId, Pageable pageable);

}
