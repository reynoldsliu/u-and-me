package tw.idv.cha102.g7.shop.service;

import tw.idv.cha102.g7.shop.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findByMemId(Integer memId, Integer page);

    Orders findByOrdId(Integer ordId);

    void insert(Orders orders);

    void delete(Integer ordId);

    void update(Integer ordId, Orders orders);
}
