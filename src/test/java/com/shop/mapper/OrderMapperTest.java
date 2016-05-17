package com.shop.mapper;

import com.shop.dto.OrderDto;
import com.shop.dto.ProductDto;
import com.shop.entity.Order;
import com.shop.entity.Phone;
import com.shop.entity.Product;
import com.shop.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.*;

import static com.shop.entity.OrderState.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by dobodzinskiy on 08.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderMapperTest {
    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private OrderMapper orderMapper = new OrderMapper();

    private static final int ID = 1;
    private static final String USERNAME = "user";
    private static final Date DATE = new Date(10, 10, 10);
    private static final BigDecimal PRICE = new BigDecimal(14999);
    private static final String PRODUCT_NAME = "Phone";

    @Test
    public void testFromDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(ID);
        orderDto.setDate(DATE);
        orderDto.setOrderState(ACCEPTED);
        orderDto.setPrice(PRICE);

        Order order = orderMapper.fromDto(orderDto);
        assertEquals(ID, order.getId());
        assertEquals(DATE, order.getDate());
        assertEquals(ACCEPTED, order.getOrderState());
        assertEquals(PRICE, order.getPrice());
    }

    @Test
    public void testToDto() {
        Order order = new Order();
        order.setId(ID);
        order.setPrice(PRICE);
        order.setOrderState(ACCEPTED);
        order.setDate(DATE);

        Product product = new Product();
        product.setName(PRODUCT_NAME);
        List<Product> productList = Arrays.asList(product);
        order.setProducts(productList);

        ProductDto productDto = new ProductDto();
        productDto.setName(PRODUCT_NAME);
        List<ProductDto> productDtoList = Arrays.asList(productDto);
        when(productMapper.toDtoList(productList)).thenReturn(productDtoList);

        User user = new User();
        user.setLogin(USERNAME);
        order.setUser(user);

        OrderDto orderDto = orderMapper.toDto(order);
        assertEquals(ID, orderDto.getId());
        assertEquals(DATE, orderDto.getDate());
        assertEquals(ACCEPTED, orderDto.getOrderState());
        assertEquals(PRICE, orderDto.getPrice());
        assertEquals(USERNAME, orderDto.getUsername());
        assertEquals(productDtoList, orderDto.getProducts());

    }
}
