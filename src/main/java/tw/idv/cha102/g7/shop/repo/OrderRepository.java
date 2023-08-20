package tw.idv.cha102.g7.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.shop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
