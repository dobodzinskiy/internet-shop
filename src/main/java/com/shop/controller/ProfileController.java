package com.shop.controller;

import com.shop.dto.OrderDto;
import com.shop.dto.UserDto;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dobodzinskiy on 16.05.2016.
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUser(authentication.getName());
    }

    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public ResponseEntity<?> changeUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<OrderDto> getProfileOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return orderService.getOrders(authentication.getName());
    }

}
