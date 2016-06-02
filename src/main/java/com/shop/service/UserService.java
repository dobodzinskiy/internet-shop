package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.dto.UserDto;

import java.util.List;

public interface UserService {

    void addUser(UserDto userDto);

    void blockUser(int id);

    List<UserDto> getUsers();

    UserDto getUser(int id);

    UserDto getUser(String login);

    UserDto updateUser(UserDto userDto);

    ProductDto addProductToFavorite(int id, String username);

    ProductDto removeProductFromFavorite(int id, String username);
}
