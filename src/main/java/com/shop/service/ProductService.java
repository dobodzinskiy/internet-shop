package com.shop.service;

import com.shop.dto.ComputerDto;
import com.shop.dto.LaptopDto;
import com.shop.dto.PhoneDto;
import com.shop.dto.ProductDto;
import com.shop.entity.ProductType;
import com.shop.entity.SortType;

import java.util.List;

public interface ProductService {

    ProductType defineProductType(int id);

    PhoneDto addPhone(PhoneDto phoneDto);
    LaptopDto addLaptop(LaptopDto laptopDto);
    ComputerDto addComputer(ComputerDto computerDto);

    PhoneDto updatePhone(PhoneDto phoneDto);
    LaptopDto updateLaptop(LaptopDto laptopDto);
    ComputerDto updateComputer(ComputerDto computerDto );

    PhoneDto getPhone(int id);
    LaptopDto getLaptop(int id);
    ComputerDto getComputer(int id);
    ProductDto getProduct(int id);

    List<PhoneDto> getPhones();
    List<LaptopDto> getLaptops();
    List<ComputerDto> getComputers();

    List<ProductDto> getTopProducts();

    List<ProductDto> getProducts(ProductType productType, SortType sortType, int page);
    List<ProductDto> searchProducts(String searchWord, SortType sortType, int page);
    List<Object> getProducts(ProductType productType);

    int getPagesCount(ProductType productType);
    int getPagesCount(String searchWord);

    void changeAvailable(int id);
}
