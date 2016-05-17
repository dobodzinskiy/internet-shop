package com.shop.service;

import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dto.ProductDto;
import com.shop.dto.UserDto;
import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.entity.UserRoles;
import com.shop.mapper.ProductMapper;
import com.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailService mailService;
    @Override
    public UserDto createUser() {
        return new UserDto();
    }

    @Override
    public void addUser(UserDto userDto) {
        userDto.setEnabled(true);
        Set<UserRoles> roles = new HashSet<>();
        roles.add(UserRoles.ROLE_USER);
        userDto.setUserRoles(roles);
        userDao.addUser(userMapper.fromDto(userDto));

        mailService.signUpMail(userDto);
    }

    @Override
    public void addWorker(UserDto userDto, UserRoles role) {
        userDto.setEnabled(true);
        Set<UserRoles> roles = new HashSet<>();
        switch (role) {
            case ROLE_ADMIN:
                roles.add(UserRoles.ROLE_ADMIN);
                roles.add(UserRoles.ROLE_USER);
                roles.add(UserRoles.ROLE_MANAGER);
                roles.add(UserRoles.ROLE_MODERATOR);
                break;
            case ROLE_MANAGER:
                roles.add(UserRoles.ROLE_USER);
                roles.add(UserRoles.ROLE_MANAGER);
                break;
            case ROLE_MODERATOR:
                roles.add(UserRoles.ROLE_MODERATOR);
                roles.add(UserRoles.ROLE_USER);
                break;
        }
        userDto.setUserRoles(roles);
        User user = userMapper.fromDto(userDto);
        user.setStaff(true);
        userDao.addUser(user);
    }

    @Override
    public List<UserDto> getStaff() {
        return userMapper.toDtoList(userDao.getStaff());
    }

    @Override
    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userDao.getUsers());
    }

    @Override
    public void deleteStaff(int id) {
        User user = userDao.getUser(id);
        Set<UserRoles> roles = new HashSet<>();
        roles.add(UserRoles.ROLE_USER);
        user.setUserRoles(roles);
        user.setStaff(false);

        userDao.updateUser(user);
    }

    @Override
    public UserDto getUser(int id) {
        return userMapper.toDto(userDao.getUser(id));
    }

    @Override
    public UserDto getUser(String login) {
        User user = userDao.findByUserLogin(login);
        return (user == null) ? null : userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        user.setProducts(userDao.getUser(userDto.getId()).getProducts());
        userDao.updateUser(user);
        return userMapper.toDto(user);
    }

    @Override
    public void ContactUser(UserDto userDto, String message) {
        mailService.customMail(userDto, message);
    }

    @Override
    public void blockUser(int id) {
        UserDto userDto = this.getUser(id);
        userDto.setEnabled(false);
        this.updateUser(userDto);
    }

    @Override
    public void unblockUser(int id) {
        UserDto userDto = this.getUser(id);
        userDto.setEnabled(true);
        this.updateUser(userDto);
    }

    @Override
    public void addProductToFavorite(int id, String username) {
        User user = userDao.findByUserLogin(username);
        user.getProducts().add(productDao.getProduct(id));
        userDao.updateUser(user);
    }

    @Override
    public void removeProductFromFavorite(int id, String username) {
        User user = userDao.findByUserLogin(username);
        user.getProducts().remove(productDao.getProduct(id));
        userDao.updateUser(user);

    }
}
