package tw.idv.cha102.g7.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.shop.entity.Orders;
import tw.idv.cha102.g7.shop.repo.OrdersRepository;
import tw.idv.cha102.g7.shop.service.OrdersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static java.lang.Integer.parseInt;

@Component
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Orders> findByMemId(HttpServletRequest request, Integer page) {
        HttpSession session = request.getSession();
        Integer memId = parseInt(session.getAttribute("memberId").toString());

        Page<Orders> pageResult = ordersRepository.findByMemId(memId, PageRequest.of(page,
                10, //每筆訂單數量
                Sort.by("ordTime").ascending())); //依造ord_time欄位從小到大排序
        List<Orders> orders = pageResult.getContent();
        return orders;
    }

    @Override
    public Orders findByOrdId(Integer ordId) {
        return ordersRepository.findById(ordId).get();
    }

    @Override
    public void insert(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void delete(Integer ordId) {
        ordersRepository.deleteById(ordId);
    }

    @Override
    public void update(Integer ordId, Orders orders) {
        if(ordersRepository.findById(ordId).isPresent()) {
            ordersRepository.save(orders);
        }
    }
}
