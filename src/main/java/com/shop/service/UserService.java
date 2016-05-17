package com.shop.service;

import com.shop.dto.UserDto;
import com.shop.entity.UserRoles;

import java.util.List;

public interface UserService {

    UserDto createUser();

    void addUser(UserDto userDto);

    void addWorker(UserDto userDto, UserRoles role);

    void deleteStaff(int id);

    List<UserDto> getStaff();

    List<UserDto> getUsers();

    UserDto getUser(int id);

    UserDto getUser(String login);

    UserDto updateUser(UserDto userDto);

    void ContactUser(UserDto userDto, String message);

    void blockUser(int id);

    void unblockUser(int id);

    void addProductToFavorite(int id, String username);

    void removeProductFromFavorite(int id, String username);
}
