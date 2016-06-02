package com.shop.controller.rest;

import com.shop.dto.OrderDto;
import com.shop.dto.UserDto;
import com.shop.service.MailService;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void blockUser(@PathVariable("id") int userId) {
        userService.blockUser(userId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<OrderDto> getHistory(@PathVariable("id") int userId) {
        return orderService.getOrders(userId);
    }

    @RequestMapping(value = "/{id}/contact", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void contactUser(@PathVariable("id") int userId, String message, String subject) {
        mailService.customMail(userService.getUser(userId), message, subject);
    }

}
