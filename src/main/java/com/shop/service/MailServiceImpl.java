package com.shop.service;

import com.shop.dto.UserDto;
import com.shop.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage templateMessage;
    @Autowired
    private SimpleMailMessage orderTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    public void signUpMail(UserDto userDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(this.templateMessage);
        simpleMailMessage.setTo(userDto.getEmail());
        simpleMailMessage.setText(
                userDto.getLogin() + ", You was successfully signed up in our shop. Follow the link below to login :\n" +
                        "http://localhost:8080/ishop/login\n" +
                        "Ishop 2016.");
        try{
            this.mailSender.send(simpleMailMessage);
        }
        catch (MailException ex) {
            LOGGER.error("SignUp mail wasn't sent to {}", userDto.getEmail(), ex);
        }
    }
    public void orderConfirmMail(Order order) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(this.orderTemplate);
        simpleMailMessage.setTo(order.getUser().getEmail());
        simpleMailMessage.setText(
                order.getUser().getLogin() + ", your order was successfully confirmed! \n" +
                        "Our manager will contact you, when your order is ready. \n" +
                        "To check order status, go to Order History in your accaunt.\n \n Ishop 2016"
        );
        try{
            this.mailSender.send(simpleMailMessage);
        }
        catch (MailException ex) {
            LOGGER.error("Order mail wasn't sent to {}", order.getUser().getEmail(), ex);
        }
    }

    public void customMail(UserDto userDto, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("admin@ishop.com");
        simpleMailMessage.setSubject("I-shop");
        simpleMailMessage.setTo(userDto.getEmail());
        simpleMailMessage.setText(message);
        try{
            this.mailSender.send(simpleMailMessage);
        }
        catch (MailException ex) {
            LOGGER.error("Mail wasn't sent to {}", userDto.getEmail(), ex);
        }
    }
}
