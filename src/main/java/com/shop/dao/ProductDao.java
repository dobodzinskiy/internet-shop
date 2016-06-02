package com.shop.dao;

import com.shop.entity.Computer;
import com.shop.entity.Laptop;
import com.shop.entity.Phone;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.entity.SortType;

import java.util.List;

public interface ProductDao {

    void addPhone(Phone phone);

    void addLaptop(Laptop laptop);

    void addComputer(Computer computer);

    void updatePhone(Phone phone);

    void updateLaptop(Laptop laptop);

    void updateComputer(Computer computer);

    Phone getPhone(int id);

    Laptop getLaptop(int id);

    Computer getComputer(int id);

    List<Phone> getPhones(int page, SortType sortType);

    List<Laptop> getLaptops(int page, SortType sortType);

    List<Computer> getComputers(int page, SortType sortType);

    int countProducts(ProductType productType);

    Product getProduct(int id);
}
