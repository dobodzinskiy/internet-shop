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

    List<Phone> getPhones();
    List<Laptop> getLaptops();
    List<Computer> getComputers();



    List<Product> getProducts(ProductType productType, SortType sortType, int productNumber, int productsPerPage);
    List<Object> getProducts(ProductType productType);
    List<Product> getProductsByName(String name, SortType sortType, int productNumber, int productsPerPage);
    List<Product> getTopProducts(int topProductsCount);
    int countProducts(ProductType productType);
    int countSearchProducts(String searchWord);
    Product getProduct(int id);
}
