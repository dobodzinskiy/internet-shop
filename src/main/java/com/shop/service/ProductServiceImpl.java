package com.shop.service;

import com.shop.dao.ProductDao;
import com.shop.dto.ComputerDto;
import com.shop.dto.LaptopDto;
import com.shop.dto.PhoneDto;
import com.shop.entity.Computer;
import com.shop.entity.Laptop;
import com.shop.entity.Phone;
import com.shop.entity.ProductType;
import com.shop.entity.SortType;
import com.shop.mapper.ComputerMapper;
import com.shop.mapper.LaptopMapper;
import com.shop.mapper.PhoneMapper;
import com.shop.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PhoneMapper phoneMapper;

    @Autowired
    private LaptopMapper laptopMapper;

    @Autowired
    private ComputerMapper computerMapper;

    @Value("${pagination.productsPerPage}")
    private Integer productsPerPage;

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<PhoneDto> getPhones(int page, String sortType) {
        int productNumber = (page - 1) * productsPerPage;
        return phoneMapper.toDtoList(productDao.getPhones(productNumber, SortType.getEnum(sortType)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LaptopDto> getLaptops(int page, String sortType) {
        int productNumber = (page - 1) * productsPerPage;
        return laptopMapper.toDtoList(productDao.getLaptops(productNumber, SortType.getEnum(sortType)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComputerDto> getComputers(int page, String sortType) {
        int productNumber = (page - 1) * productsPerPage;
        return computerMapper.toDtoList(productDao.getComputers(productNumber, SortType.getEnum(sortType)));
    }

    @Override
    @Transactional(readOnly = true)
    public int getPagesCount(String productType) {
        return (int) Math.ceil(1.0 * productDao.countProducts(ProductType.getEnum(productType)) / productsPerPage);
    }

    @Override
    public void changeAvailable(int id) {
        switch (defineProductType(id)) {
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
            default:
                String message = "Product type in undefined";
                LOGGER.error(message);
                throw new IllegalArgumentException(message);
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
    @Transactional(readOnly = true)
    public PhoneDto getPhone(int id) {
        return phoneMapper.toDto(productDao.getPhone(id));
    }

    @Override
    @Transactional(readOnly = true)
    public LaptopDto getLaptop(int id) {
        return laptopMapper.toDto(productDao.getLaptop(id));
    }

    @Override
    @Transactional(readOnly = true)
    public ComputerDto getComputer(int id) {
        return computerMapper.toDto(productDao.getComputer(id));
    }

}
