package com.shop.service;

import com.shop.dto.ComputerDto;
import com.shop.dto.LaptopDto;
import com.shop.dto.PhoneDto;
import com.shop.entity.ProductType;

import java.util.List;

public interface ProductService {

    ProductType defineProductType(int id);

    PhoneDto addPhone(PhoneDto phoneDto);

    LaptopDto addLaptop(LaptopDto laptopDto);

    ComputerDto addComputer(ComputerDto computerDto);

    PhoneDto updatePhone(PhoneDto phoneDto);

    LaptopDto updateLaptop(LaptopDto laptopDto);

    ComputerDto updateComputer(ComputerDto computerDto);

    PhoneDto getPhone(int id);

    LaptopDto getLaptop(int id);

    ComputerDto getComputer(int id);

    List<PhoneDto> getPhones(int page, String sortType);

    List<LaptopDto> getLaptops(int page, String sortType);

    List<ComputerDto> getComputers(int page, String sortType);

    int getPagesCount(String productType);

    void changeAvailable(int id);
}
