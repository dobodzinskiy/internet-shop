package com.shop.service;

import com.shop.dto.UserDto;
import com.shop.entity.Order;

public interface MailService {
    void signUpMail(UserDto userDto);
    void orderConfirmMail(Order order);
    void customMail(UserDto userDto, String message);
}
