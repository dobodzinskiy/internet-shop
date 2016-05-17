package com.shop.mapper;

import com.shop.dto.UserDto;
import com.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dobodzinskiy on 15.03.2016.
 */
@Component("userMapper")
public class UserMapper implements Mapper<User, UserDto> {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public User fromDto(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLogin(userDto.getLogin());
        user.setPhone(userDto.getPhone());
        user.setUserRoles(userDto.getUserRoles());
        user.setEnabled(userDto.isEnabled());
        user.setStaff(userDto.isStaff());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setLogin(user.getLogin());
        userDto.setPhone(user.getPhone());
        userDto.setUserRoles(user.getUserRoles());
        userDto.setEnabled(user.isEnabled());
        userDto.setStaff(user.isStaff());
        userDto.setProducts(productMapper.toDtoList(user.getProducts()));
        return userDto;
    }

    @Override
    public List<UserDto> toDtoList(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users) {
            userDtos.add(this.toDto(user));
        }
        return userDtos;
    }

    @Override
    public List<User> fromDtoList(List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        for(UserDto userDto : userDtos) {
        }
        return users;
    }
}
