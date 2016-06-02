package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("productMapper")
public class ProductMapper implements Mapper<Product, ProductDto> {

    @Override
    public Product fromDto(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPhoto(product.getPhoto());
        productDto.setType(product.getType().getValue());
        return productDto;
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> products) {
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Product> fromDtoList(List<ProductDto> productDtoList) {
        return null;
    }
}
