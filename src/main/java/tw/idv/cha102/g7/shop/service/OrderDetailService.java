package tw.idv.cha102.g7.shop.service;

import tw.idv.cha102.g7.shop.entity.OrderDetail;
import tw.idv.cha102.g7.shop.entity.OrderDetailId;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findByIdOrdId(Integer ordId, Integer page);

    void insert(OrderDetail orderDetail);

    void update(OrderDetailId orderDetailId, OrderDetail orderDetail);

    void delete(OrderDetailId orderDetailId);

}
