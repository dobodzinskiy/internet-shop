package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductMapperTest {

    private ProductMapper productMapper = new ProductMapper();

    @Test
    public void testFromDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("HTC 1");
        Product product = productMapper.fromDto(productDto);
        assertNull(product);
    }

    @Test
    public void testToDto() {
        Product product = new Product();

        product.setId(1);
        product.setName("HTC 1");
        product.setPhoto("macbookair.jpg");
        product.setPrice(BigDecimal.valueOf(14999));
        product.setType(ProductType.PHONES);
        product.setAvailable(true);

        ProductDto productDto = productMapper.toDto(product);
        assertEquals(1, productDto.getId());
        assertEquals("HTC 1", productDto.getName());
        assertEquals("macbookair.jpg", productDto.getPhoto());
        assertEquals(ProductType.PHONES.getValue(), productDto.getType());
    }

    @Test
    public void testToDtoList() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();

        product.setId(1);
        product.setName("HTC 1");
        product.setPhoto("macbookair.jpg");
        product.setPrice(BigDecimal.valueOf(14999));
        product.setType(ProductType.PHONES);
        product.setAvailable(true);

        products.add(product);

        List<ProductDto> productDtos = productMapper.toDtoList(products);
        for(ProductDto productDto : productDtos) {
            assertEquals(1, productDto.getId());
            assertEquals("HTC 1", productDto.getName());
        }
    }

    @Test
    public void testFromDtoList() {
        List<ProductDto> productDtos = new ArrayList<>();
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("HTC 1");

        productDtos.add(productDto);
        List<Product> products = productMapper.fromDtoList(productDtos);
        assertNull(products);
    }
}
