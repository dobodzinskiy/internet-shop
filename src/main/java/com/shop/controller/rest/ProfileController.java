package com.shop.controller.rest;

import com.shop.dto.OrderDto;
import com.shop.dto.ProductDto;
import com.shop.dto.UserDto;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Secured("ROLE_USER")
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
    @ResponseStatus(HttpStatus.OK)
    public UserDto changeUser(@Valid @RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<OrderDto> getProfileOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return orderService.getOrders(authentication.getName());
    }

    @RequestMapping(value = "/favorite/{id}", method = RequestMethod.POST)
    public ProductDto toFavorites(@PathVariable("id") int productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.addProductToFavorite(productId, authentication.getName());
    }

    @RequestMapping(value = "/favorite/{id}", method = RequestMethod.DELETE)
    public ProductDto fromFavorites(@PathVariable("id") int productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.removeProductFromFavorite(productId, authentication.getName());
    }

}
