package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        return productDto;
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> products) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : products) {
            productDtoList.add(this.toDto(product));
        }
        return productDtoList;
    }

    @Override
    public List<Product> fromDtoList(List<ProductDto> productDtoList) {
        return null;
    }
}
