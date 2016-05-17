package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.dto.UserDto;
import com.shop.entity.Phone;
import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.entity.UserRoles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String GENDER = "Male";
    private static final String EMAIL = "john@doe.com";
    private static final String PASSWORD = "password";
    private static final String LOGIN = "joe";
    private static final String PHONE = "+3809999999";
    private static final String PRODUCT_NAME = "Phone";

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private UserMapper userMapper = new UserMapper();

    @Test
    public void testFromDto() {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName(FIRST_NAME);
        userDto.setLastName(LAST_NAME);
        userDto.setGender(GENDER);
        userDto.setEmail(EMAIL);
        userDto.setPassword(PASSWORD);
        userDto.setLogin(LOGIN);
        userDto.setPhone(PHONE);
        userDto.setUserRoles(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)));
        userDto.setEnabled(true);
        userDto.setStaff(false);

        User user = userMapper.fromDto(userDto);
        assertEquals(1, user.getId());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertEquals(GENDER, user.getGender());
        assertEquals(EMAIL, user.getEmail());
        assertEquals(PASSWORD, user.getPassword());
        assertEquals(LOGIN, user.getLogin());
        assertEquals(PHONE, user.getPhone());
        assertEquals(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)), user.getUserRoles());
        assertEquals(true, user.isEnabled());
        assertEquals(false, user.isStaff());
    }

    @Test
    public void testToDto() {
        User user = new User();
        user.setId(1);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setGender(GENDER);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setLogin(LOGIN);
        user.setPhone(PHONE);
        user.setUserRoles(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)));
        user.setEnabled(true);
        user.setStaff(false);

        Product product = new Phone();
        product.setName(PRODUCT_NAME);
        List<Product> productList = Arrays.asList(product);
        user.setProducts(productList);

        ProductDto productDto = new ProductDto();
        product.setName(PRODUCT_NAME);
        List<ProductDto> productDtoList = Arrays.asList(productDto);
        when(productMapper.toDtoList(productList)).thenReturn(productDtoList);

        UserDto userDto = userMapper.toDto(user);
        assertEquals(1, userDto.getId());
        assertEquals(FIRST_NAME, userDto.getFirstName());
        assertEquals(LAST_NAME, userDto.getLastName());
        assertEquals(GENDER, userDto.getGender());
        assertEquals(EMAIL, userDto.getEmail());
        assertEquals(PASSWORD, userDto.getPassword());
        assertEquals(LOGIN, userDto.getLogin());
        assertEquals(PHONE, userDto.getPhone());
        assertEquals(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)), user.getUserRoles());
        assertEquals(true, userDto.isEnabled());
        assertEquals(false, userDto.isStaff());
        assertEquals(productDtoList, userDto.getProducts());
    }

    @Test
    public void testFromDtoList() {
        List<UserDto> userDtos = new ArrayList<>();
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName(FIRST_NAME);
        userDto.setLastName(LAST_NAME);
        userDto.setGender(GENDER);
        userDto.setEmail(EMAIL);
        userDto.setPassword(PASSWORD);
        userDto.setLogin(LOGIN);
        userDto.setPhone(PHONE);
        userDto.setUserRoles(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)));
        userDto.setEnabled(true);
        userDto.setStaff(false);
        userDtos.add(userDto);

        List<User> users = userMapper.fromDtoList(userDtos);
        for(User user : users) {
            assertEquals(1, user.getId());
            assertEquals(FIRST_NAME, user.getFirstName());
            assertEquals(LAST_NAME, user.getLastName());
            assertEquals(GENDER, user.getGender());
            assertEquals(EMAIL, user.getEmail());
            assertEquals(PASSWORD, user.getPassword());
            assertEquals(LOGIN, user.getLogin());
            assertEquals(PHONE, user.getPhone());
            assertEquals(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)), user.getUserRoles());
            assertEquals(true, user.isEnabled());
            assertEquals(false, user.isStaff());
        }
    }

    @Test
    public void testToDtoList() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setGender(GENDER);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setLogin(LOGIN);
        user.setPhone(PHONE);
        user.setUserRoles(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)));
        user.setEnabled(true);
        user.setStaff(false);

        Product product = new Phone();
        product.setName(PRODUCT_NAME);
        List<Product> productList = Arrays.asList(product);
        user.setProducts(productList);

        users.add(user);

        ProductDto productDto = new ProductDto();
        product.setName(PRODUCT_NAME);
        List<ProductDto> productDtoList = Arrays.asList(productDto);
        when(productMapper.toDtoList(productList)).thenReturn(productDtoList);

        List<UserDto> userDtos = userMapper.toDtoList(users);
        for(UserDto userDto : userDtos) {
            assertEquals(1, userDto.getId());
            assertEquals(FIRST_NAME, userDto.getFirstName());
            assertEquals(LAST_NAME, userDto.getLastName());
            assertEquals(GENDER, userDto.getGender());
            assertEquals(EMAIL, userDto.getEmail());
            assertEquals(PASSWORD, userDto.getPassword());
            assertEquals(LOGIN, userDto.getLogin());
            assertEquals(PHONE, userDto.getPhone());
            assertEquals(new HashSet<>(Arrays.asList(UserRoles.ROLE_USER)), user.getUserRoles());
            assertEquals(true, userDto.isEnabled());
            assertEquals(false, userDto.isStaff());
            assertEquals(productDtoList, userDto.getProducts());
        }
    }
}
