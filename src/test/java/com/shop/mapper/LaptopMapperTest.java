package com.shop.mapper;


import com.shop.dto.LaptopDto;
import com.shop.entity.Laptop;
import com.shop.entity.ProductType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LaptopMapperTest {

    private LaptopMapper laptopMapper = new LaptopMapper();

    @Test
    public void testFromDto() {
        LaptopDto laptopDto = new LaptopDto();

        laptopDto.setId(1);
        laptopDto.setName("name");
        laptopDto.setPhoto("photo");
        laptopDto.setPrice(BigDecimal.valueOf(1000));
        laptopDto.setModel("model");
        laptopDto.setType(ProductType.LAPTOPS.getValue());
        laptopDto.setAvailable(true);
        laptopDto.setSize("10 x 10");
        laptopDto.setWeight(100);
        laptopDto.setStorage(10);
        laptopDto.setRam(10);
        laptopDto.setScreen((float)10);
        laptopDto.setOs("os");
        laptopDto.setColor("color");
        laptopDto.setDescription("description");
        laptopDto.setProcessor("processor");
        laptopDto.setCompany("company");
        laptopDto.setKeyboardLight(true);

        Laptop laptop = laptopMapper.fromDto(laptopDto);

        assertEquals(1, laptop.getId());
        assertEquals("name", laptop.getName());
        assertEquals("photo", laptop.getPhoto());
        assertEquals(BigDecimal.valueOf(1000), laptop.getPrice());
        assertEquals("model", laptop.getModel());
        assertEquals(ProductType.LAPTOPS, laptop.getType());
        assertTrue(laptop.isAvailable());
        assertEquals("10 x 10", laptop.getSize());
        assertEquals(100, laptop.getWeight());
        assertEquals(10, laptop.getStorage());
        assertEquals(10, laptop.getRam());
        assertEquals(10, laptop.getScreen(), 0.0);
        assertEquals("os", laptop.getOs());
        assertEquals("color", laptop.getColor());
        assertEquals("description", laptop.getDescription());
        assertEquals("processor", laptop.getProcessor());
        assertEquals("company", laptop.getCompany());
        assertTrue(laptop.isKeyboardLight());
    }

    @Test
    public void testToDto() {
        Laptop laptop = new Laptop();

        laptop.setId(1);
        laptop.setName("name");
        laptop.setPhoto("photo");
        laptop.setPrice(BigDecimal.valueOf(1000));
        laptop.setModel("model");
        laptop.setType(ProductType.LAPTOPS);
        laptop.setAvailable(true);
        laptop.setSize("10 x 10");
        laptop.setWeight(100);
        laptop.setStorage(10);
        laptop.setRam(10);
        laptop.setScreen((float)10);
        laptop.setOs("os");
        laptop.setColor("color");
        laptop.setDescription("description");
        laptop.setProcessor("processor");
        laptop.setCompany("company");
        laptop.setKeyboardLight(true);

        LaptopDto laptopDto = laptopMapper.toDto(laptop);
        assertEquals(1, laptopDto.getId());
        assertEquals("name", laptopDto.getName());
        assertEquals("photo", laptopDto.getPhoto());
        assertEquals(BigDecimal.valueOf(1000), laptopDto.getPrice());
        assertEquals("model", laptopDto.getModel());
        assertEquals(ProductType.LAPTOPS.getValue(), laptopDto.getType());
        assertTrue(laptopDto.isAvailable());
        assertEquals("10 x 10", laptopDto.getSize());
        assertEquals(100, (int) laptopDto.getWeight());
        assertEquals(10,(int) laptopDto.getStorage());
        assertEquals(10, (int) laptopDto.getRam());
        assertEquals((float)10, laptopDto.getScreen(), 0.0);
        assertEquals("os", laptopDto.getOs());
        assertEquals("color", laptopDto.getColor());
        assertEquals("description", laptopDto.getDescription());
        assertEquals("processor", laptopDto.getProcessor());
        assertEquals("company", laptopDto.getCompany());
        assertTrue(laptopDto.isKeyboardLight());
    }

    @Test
    public void testToDtoList() {
        List<Laptop> laptops = new ArrayList<>();
        Laptop laptop = new Laptop();

        laptop.setId(1);
        laptop.setName("name");
        laptop.setPhoto("photo");
        laptop.setPrice(BigDecimal.valueOf(1000));
        laptop.setModel("model");
        laptop.setType(ProductType.LAPTOPS);
        laptop.setAvailable(true);
        laptop.setSize("10 x 10");
        laptop.setWeight(100);
        laptop.setStorage(10);
        laptop.setRam(10);
        laptop.setScreen((float)10);
        laptop.setOs("os");
        laptop.setColor("color");
        laptop.setDescription("description");
        laptop.setProcessor("processor");
        laptop.setCompany("company");
        laptop.setKeyboardLight(true);

        laptops.add(laptop);

        List<LaptopDto> laptopDtos = laptopMapper.toDtoList(laptops);
        for(LaptopDto laptopDto : laptopDtos) {
            assertEquals(1, laptopDto.getId());
            assertEquals("name", laptopDto.getName());
            assertEquals("photo", laptopDto.getPhoto());
            assertEquals(BigDecimal.valueOf(1000), laptopDto.getPrice());
            assertEquals("model", laptopDto.getModel());
            assertEquals(ProductType.LAPTOPS.getValue(), laptopDto.getType());
            assertTrue(laptopDto.isAvailable());
            assertEquals("10 x 10", laptopDto.getSize());
            assertEquals(100, (int) laptopDto.getWeight());
            assertEquals(10,(int) laptopDto.getStorage());
            assertEquals(10, (int) laptopDto.getRam());
            assertEquals((float)10, laptopDto.getScreen(), 0.0);
            assertEquals("os", laptopDto.getOs());
            assertEquals("color", laptopDto.getColor());
            assertEquals("description", laptopDto.getDescription());
            assertEquals("processor", laptopDto.getProcessor());
            assertEquals("company", laptopDto.getCompany());
            assertTrue(laptopDto.isKeyboardLight());
        }
    }

    @Test
    public void testFromDtoList() {
        List<LaptopDto> laptopDtos = new ArrayList<>();
        LaptopDto laptopDto = new LaptopDto();

        laptopDto.setId(1);
        laptopDto.setName("name");
        laptopDto.setPhoto("photo");
        laptopDto.setPrice(BigDecimal.valueOf(1000));
        laptopDto.setModel("model");
        laptopDto.setType(ProductType.LAPTOPS.getValue());
        laptopDto.setAvailable(true);
        laptopDto.setSize("10 x 10");
        laptopDto.setWeight(100);
        laptopDto.setStorage(10);
        laptopDto.setRam(10);
        laptopDto.setScreen((float) 10);
        laptopDto.setOs("os");
        laptopDto.setColor("color");
        laptopDto.setDescription("description");
        laptopDto.setProcessor("processor");
        laptopDto.setCompany("company");
        laptopDto.setKeyboardLight(true);

        laptopDtos.add(laptopDto);

        List<Laptop> laptopList = laptopMapper.fromDtoList(laptopDtos);

        for (Laptop laptop : laptopList) {
            assertEquals(1, laptop.getId());
            assertEquals("name", laptop.getName());
            assertEquals("photo", laptop.getPhoto());
            assertEquals(BigDecimal.valueOf(1000), laptop.getPrice());
            assertEquals("model", laptop.getModel());
            assertEquals(ProductType.LAPTOPS, laptop.getType());
            assertTrue(laptop.isAvailable());
            assertEquals("10 x 10", laptop.getSize());
            assertEquals(100, laptop.getWeight());
            assertEquals(10, laptop.getStorage());
            assertEquals(10, laptop.getRam());
            assertEquals((float) 10, laptop.getScreen(), 0.0);
            assertEquals("os", laptop.getOs());
            assertEquals("color", laptop.getColor());
            assertEquals("description", laptop.getDescription());
            assertEquals("processor", laptop.getProcessor());
            assertEquals("company", laptop.getCompany());
            assertTrue(laptop.isKeyboardLight());
        }
    }
}

