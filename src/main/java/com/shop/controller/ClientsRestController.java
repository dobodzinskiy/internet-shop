package com.shop.controller;


import com.shop.dto.OrderDto;
import com.shop.dto.UserDto;
import com.shop.entity.UserRoles;
import com.shop.service.MailService;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping("/clients")
public class ClientsRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/{id}/block", method = RequestMethod.PUT)
    public ResponseEntity<?> blockUser(@PathVariable("id") int userId) {
        userService.blockUser(userId);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/history", method = RequestMethod.GET)
    public List<OrderDto> getHistory(@PathVariable("id") int userId) {
        return orderService.getOrders(userId);
    }

    @RequestMapping(value = "/{id}/contact", method = RequestMethod.GET)
    public ResponseEntity<?> contactUser(@PathVariable("id") int userId, String text) {
        mailService.customMail(userService.getUser(userId), text);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public UserDto getUser(@PathVariable("id") int userId) {
//        return userService.getUser(userId);
//    }

//    @RequestMapping(value = "/{id}/change", method = RequestMethod.PUT)
//    public ResponseEntity<?> changeUser(@PathVariable("id") int userId, @RequestBody UserDto userDto) {
//        userService.updateUser(userDto);
//        return new ResponseEntity<String>(HttpStatus.OK);
//    }

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public List<UserDto> getStaff() {
        return userService.getStaff();
    }

    @RequestMapping(value = "/addStaff", method = RequestMethod.POST)
    public ResponseEntity<?> addStaff(@RequestBody UserDto userDto, UserRoles role) {
        userService.addWorker(userDto, role);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/deleteStaff", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteStaff(@PathVariable("id") int userId) {
        userService.deleteStaff(userId);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
