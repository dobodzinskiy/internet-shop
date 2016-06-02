package com.shop.mapper;

import com.shop.dto.UserDto;
import com.shop.entity.User;
import com.shop.entity.UserRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dobodzinskiy on 15.03.2016.
 */
@Component("userMapper")
public class UserMapper implements Mapper<User, UserDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);

    @Autowired
    private ProductMapper productMapper;

    @Override
    public User fromDto(UserDto userDto) {
        User user = new User();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLogin(userDto.getLogin());

        try {
            user.setDate(formatter.parse(userDto.getDate()));
        } catch (ParseException e) {
            LOGGER.error("Cannot convert date");
        }
        user.setPhone(userDto.getPhone());
        Set<UserRoles> userRoles = new HashSet<>();
        for (String role : userDto.getUserRoles()) {
            userRoles.add(UserRoles.getEnum(role));
        }
        user.setUserRoles(userRoles);
        user.setEnabled(userDto.isEnabled());
        user.setStaff(userDto.isStaff());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setLogin(user.getLogin());
        userDto.setDate(formatter.format(user.getDate()));
        userDto.setPhone(user.getPhone());
        Set<String> roles = new HashSet<>();
        for (UserRoles userRoles : user.getUserRoles()) {
            roles.add(userRoles.getValue());
        }
        userDto.setUserRoles(roles);
        userDto.setEnabled(user.isEnabled());
        userDto.setStaff(user.isStaff());
        userDto.setProducts(productMapper.toDtoList(user.getProducts()));
        return userDto;
    }

    @Override
    public List<UserDto> toDtoList(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<User> fromDtoList(List<UserDto> userDtos) {
        return userDtos.stream().map(this::fromDto).collect(Collectors.toList());
    }
}
