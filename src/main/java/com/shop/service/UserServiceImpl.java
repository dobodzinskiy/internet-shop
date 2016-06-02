package com.shop.service;

import com.shop.dao.OrderDao;
import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dto.ProductDto;
import com.shop.dto.UserDto;
import com.shop.entity.User;
import com.shop.entity.UserRoles;
import com.shop.mapper.ProductMapper;
import com.shop.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MailService mailService;

    @Override
    public void addUser(UserDto userDto) {
        userDto.setEnabled(true);
        userDto.setStaff(false);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        userDto.setDate(formatter.format(new Date(System.currentTimeMillis())));
        Set<String> roles = new HashSet<>();
        roles.add(UserRoles.ROLE_USER.getValue());
        userDto.setUserRoles(roles);
        userDao.addUser(userMapper.fromDto(userDto));
        mailService.signUpMail(userDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userDao.getUsers());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(int id) {
        return userMapper.toDto(userDao.getUser(id));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(String login) {
        User user = userDao.findByUserLogin(login);
        return (user == null) ? null : userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        user.setOrders(orderDao.getOrders(userDto.getId()));
        user.setProducts(userDao.getUser(userDto.getId()).getProducts());
        userDao.updateUser(user);
        return userMapper.toDto(user);
    }

    @Override
    public void blockUser(int id) {
        UserDto userDto = this.getUser(id);
        userDto.setEnabled(!userDto.isEnabled());
        this.updateUser(userDto);
    }

    @Override
    public ProductDto addProductToFavorite(int id, String username) {
        User user = userDao.findByUserLogin(username);
        user.getProducts().add(productDao.getProduct(id));
        userDao.updateUser(user);

        return productMapper.toDto(productDao.getProduct(id));
    }

    @Override
    public ProductDto removeProductFromFavorite(int id, String username) {
        User user = userDao.findByUserLogin(username);
        user.getProducts().remove(productDao.getProduct(id));
        userDao.updateUser(user);

        return productMapper.toDto(productDao.getProduct(id));
    }
}
