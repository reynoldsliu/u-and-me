package tw.idv.cha102.g7.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.shop.entity.OrderDetail;
import tw.idv.cha102.g7.shop.entity.OrderDetailId;
import tw.idv.cha102.g7.shop.repo.OrderDetailRepository;
import tw.idv.cha102.g7.shop.service.OrderDetailService;

import java.util.List;

@Component
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findByIdOrdId(Integer ordId, Integer page) {
        Page<OrderDetail> pageResult = orderDetailRepository.findAll(
                PageRequest.of(page, //查詢的頁數 從0開始
                        10,//查詢的每頁筆數
                        Sort.by("groupSta").ascending())); //依造group_sta欄位升冪排序
        List<OrderDetail> orderDetailList = pageResult.getContent();
        return orderDetailList;
    }

    @Override
    public void insert(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void update(OrderDetailId orderDetailId, OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(OrderDetailId orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }
}
