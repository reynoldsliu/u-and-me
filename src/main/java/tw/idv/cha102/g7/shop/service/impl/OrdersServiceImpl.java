package tw.idv.cha102.g7.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.customer.entity.ContentEmail;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.MemberRepository;
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

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MemberRepository memberRepository;

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
        Member member = memberRepository.findById(orders.getMemId()).orElse(null);
        String recieverEmail = member.getMemEmail();
        ordersRepository.save(orders);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("xiaoina914@gmail.com");//寄出信件的信箱
        message.setTo(recieverEmail);//接收信件的信箱
        message.setSubject("U-and-Me 客服郵件");//信件主旨
        message.setText("收件人姓名：" + member.getMemName()+"\n\n"+
                "收件人信箱：" + member.getMemEmail()+"\n\n"+
                "收件人地址：" + member.getMemCity()+member.getMemDist()+member.getMemAddr()+"\n\n"+
                "＊－。－。－。－。－ 收件人留言 －。－。－。－。－＊\n\n"+
                "您的商品已寄出，請確認查收!"+"\n\n\n\n\n\n"+
                "From U-and-Me"+
                "＊－。－。－。－。－。－。－。－－。－。－。－。－＊");//信件內容 長String 可以加\n換行

        mailSender.send(message);
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
