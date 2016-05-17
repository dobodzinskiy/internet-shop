package com.shop.service;

import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dto.ComputerDto;
import com.shop.dto.LaptopDto;
import com.shop.dto.PhoneDto;
import com.shop.dto.ProductDto;
import com.shop.entity.*;
import com.shop.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PhoneMapper phoneMapper;
    @Autowired
    private LaptopMapper laptopMapper;
    @Autowired
    private ComputerMapper computerMapper;
    @Value("${pagination.productsPerPage}")
    private Integer ProductsPerPage;
    @Value("${products.topProducts}")
    private Integer topProductsCount;

    public ProductType defineProductType(int id) {
        return productDao.getProduct(id).getType();
    }

    @Override
    public PhoneDto addPhone(PhoneDto phoneDto) {
        Phone phone = phoneMapper.fromDto(phoneDto);
        productDao.addPhone(phone);
        return phoneMapper.toDto(phone);
    }

    @Override
    public LaptopDto addLaptop(LaptopDto laptopDto) {
        Laptop laptop = laptopMapper.fromDto(laptopDto);
        productDao.addLaptop(laptopMapper.fromDto(laptopDto));
        return laptopMapper.toDto(laptop);
    }

    @Override
    public ComputerDto addComputer(ComputerDto computerDto) {
        Computer computer = computerMapper.fromDto(computerDto);
        productDao.addComputer(computerMapper.fromDto(computerDto));
        return computerMapper.toDto(computer);
    }

    @Override
    public List<PhoneDto> getPhones() {
        return phoneMapper.toDtoList(productDao.getPhones());
    }

    @Override
    public List<LaptopDto> getLaptops() {
        return laptopMapper.toDtoList(productDao.getLaptops());
    }

    @Override
    public List<ComputerDto> getComputers() {
        return computerMapper.toDtoList(productDao.getComputers());
    }

    @Override
    public List<ProductDto> getTopProducts() {
        return productMapper.toDtoList(productDao.getTopProducts(topProductsCount));
    }

    @Override
    public List<ProductDto> getProducts(ProductType productType, SortType sortType, int page) {
        int productNumber = (page - 1) * ProductsPerPage;
        return productMapper.toDtoList(productDao.getProducts(productType, sortType, productNumber, ProductsPerPage));
    }

    @Override
    public List<Object> getProducts(ProductType productType) {
        return productDao.getProducts(productType);
    }

    @Override
    public int getPagesCount(ProductType productType) {

        return (int) Math.ceil(1.0 * productDao.countProducts(productType) / ProductsPerPage);
    }

    @Override
    public int getPagesCount(String searchWord) {
        return (int) Math.ceil(1.0 * productDao.countSearchProducts(searchWord) / ProductsPerPage);
    }

    @Override
    public List<ProductDto> searchProducts(String searchWord, SortType sortType, int page) {
        int productNumber = (page - 1) * ProductsPerPage;
        return productMapper.toDtoList(productDao.getProductsByName(searchWord, sortType, productNumber, ProductsPerPage));
    }

    @Override
    public void changeAvailable(int id) {
        switch(this.defineProductType(id)) {
            case COMPUTERS:
                Computer computer = productDao.getComputer(id);
                computer.setAvailable(!computer.isAvailable());
                productDao.updateComputer(computer);
                break;
            case LAPTOPS:
                Laptop laptop = productDao.getLaptop(id);
                laptop.setAvailable(!laptop.isAvailable());
                productDao.updateLaptop(laptop);
                break;
            case PHONES:
                Phone phone = productDao.getPhone(id);
                phone.setAvailable(!phone.isAvailable());
                productDao.updatePhone(phone);
                break;
        }
    }

    @Override
    public PhoneDto updatePhone(PhoneDto phoneDto) {
        Phone phone = phoneMapper.fromDto(phoneDto);
        productDao.updatePhone(phone);
        return phoneMapper.toDto(phone);
    }

    @Override
    public LaptopDto updateLaptop(LaptopDto laptopDto) {
        Laptop laptop = laptopMapper.fromDto(laptopDto);
        productDao.updateLaptop(laptop);
        return laptopMapper.toDto(laptop);
    }

    @Override
    public ComputerDto updateComputer(ComputerDto computerDto) {
        Computer computer = computerMapper.fromDto(computerDto);
        productDao.updateComputer(computer);
        return computerMapper.toDto(computer);
    }

    @Override
    public PhoneDto getPhone(int id) {
        return phoneMapper.toDto(productDao.getPhone(id));
    }

    @Override
    public LaptopDto getLaptop(int id) {
        return laptopMapper.toDto(productDao.getLaptop(id));
    }

    @Override
    public ComputerDto getComputer(int id) {
        return computerMapper.toDto(productDao.getComputer(id));
    }

    @Override
    public ProductDto getProduct(int id) {
        return productMapper.toDto(productDao.getProduct(id));
    }

}
