package tw.idv.cha102.g7.customer.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.customer.entity.ContentEmail;
import tw.idv.cha102.g7.customer.service.ContactMailService;

@Service
public class ContactMailServiceImpl implements ContactMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    public void sendContactMail(ContentEmail contentEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(mailFrom);
        message.setSubject("U-and-Me 客服郵件");
        message.setText("寄件人姓名：" + contentEmail.getName()+"\n\n"+
                "寄件人信箱：" + contentEmail.getUsermail()+"\n\n"+
                "＊－。－。－。－。－ 寄件人留言 －。－。－。－。－＊\n\n"+
                contentEmail.getContent()+"\n\n"+
                "＊－。－。－。－。－。－。－。－－。－。－。－。－＊");

        mailSender.send(message);
    }
}
