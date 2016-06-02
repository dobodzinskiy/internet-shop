package com.shop.mapper;

import com.shop.dto.PhoneDto;
import com.shop.entity.Phone;
import com.shop.entity.ProductType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PhoneMapperTest {

    private PhoneMapper phoneMapper = new PhoneMapper();

    @Test
    public void testFromDto() {
        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setId(1);
        phoneDto.setName("name");
        phoneDto.setPhoto("photo");
        phoneDto.setPrice(BigDecimal.valueOf(1000));
        phoneDto.setModel("model");
        phoneDto.setType(ProductType.PHONES.getValue());
        phoneDto.setAvailable(true);
        phoneDto.setSize("10 x 10");
        phoneDto.setWeight(100);
        phoneDto.setStorage(10);
        phoneDto.setRam(10);
        phoneDto.setScreen((float)10);
        phoneDto.setOs("os");
        phoneDto.setColor("color");
        phoneDto.setDescription("description");
        phoneDto.setProcessor("processor");
        phoneDto.setCompany("company");
        phoneDto.setDualSim(true);
        phoneDto.setSimType("type");
        phoneDto.setMessageType("type");

        Phone phone = phoneMapper.fromDto(phoneDto);

        assertEquals(1, phone.getId());
        assertEquals("name", phone.getName());
        assertEquals("photo", phone.getPhoto());
        assertEquals(BigDecimal.valueOf(1000), phone.getPrice());
        assertEquals("model", phone.getModel());
        assertEquals(ProductType.PHONES, phone.getType());
        assertEquals(true, phone.isAvailable());
        assertEquals("10 x 10", phone.getSize());
        assertEquals(100, phone.getWeight());
        assertEquals(10, phone.getStorage());
        assertEquals(10, phone.getRam());
        assertEquals(10, phone.getScreen(), 0.0);
        assertEquals("os", phone.getOs());
        assertEquals("color", phone.getColor());
        assertEquals("description", phone.getDescription());
        assertEquals("processor", phone.getProcessor());
        assertEquals("company", phone.getCompany());
        assertEquals(true, phone.isDualSim());
        assertEquals("type", phone.getSimType());
        assertEquals("type", phone.getMessageType());
    }

    @Test
    public void testToDto() {
        Phone phone = new Phone();

        phone.setId(1);
        phone.setName("name");
        phone.setPhoto("photo");
        phone.setPrice(BigDecimal.valueOf(1000));
        phone.setModel("model");
        phone.setType(ProductType.PHONES);
        phone.setAvailable(true);
        phone.setSize("10 x 10");
        phone.setWeight(100);
        phone.setStorage(10);
        phone.setRam(10);
        phone.setScreen((float)10);
        phone.setOs("os");
        phone.setColor("color");
        phone.setDescription("description");
        phone.setProcessor("processor");
        phone.setCompany("company");
        phone.setDualSim(true);
        phone.setSimType("type");
        phone.setMessageType("type");

        PhoneDto phoneDto = phoneMapper.toDto(phone);
        assertEquals(1, phoneDto.getId());
        assertEquals("name", phoneDto.getName());
        assertEquals("photo", phoneDto.getPhoto());
        assertEquals(BigDecimal.valueOf(1000), phoneDto.getPrice());
        assertEquals("model", phoneDto.getModel());
        assertEquals(ProductType.PHONES.getValue(), phoneDto.getType());
        assertEquals(true, phoneDto.isAvailable());
        assertEquals("10 x 10", phoneDto.getSize());
        assertEquals(100, (int) phoneDto.getWeight());
        assertEquals(10,(int) phoneDto.getStorage());
        assertEquals(10, (int) phoneDto.getRam());
        assertEquals((float)10, phoneDto.getScreen(), 0.0);
        assertEquals("os", phoneDto.getOs());
        assertEquals("color", phoneDto.getColor());
        assertEquals("description", phoneDto.getDescription());
        assertEquals("processor", phoneDto.getProcessor());
        assertEquals("company", phoneDto.getCompany());
        assertEquals(true, phoneDto.isDualSim());
        assertEquals("type", phoneDto.getSimType());
        assertEquals("type", phoneDto.getMessageType());
    }

    @Test
    public void testToDtoList() {
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();

        phone.setId(1);
        phone.setName("name");
        phone.setPhoto("photo");
        phone.setPrice(BigDecimal.valueOf(1000));
        phone.setModel("model");
        phone.setType(ProductType.PHONES);
        phone.setAvailable(true);
        phone.setSize("10 x 10");
        phone.setWeight(100);
        phone.setStorage(10);
        phone.setRam(10);
        phone.setScreen((float)10);
        phone.setOs("os");
        phone.setColor("color");
        phone.setDescription("description");
        phone.setProcessor("processor");
        phone.setCompany("company");
        phone.setDualSim(true);
        phone.setSimType("type");
        phone.setMessageType("type");

        phones.add(phone);

        List<PhoneDto> phoneDtos = phoneMapper.toDtoList(phones);
        for(PhoneDto phoneDto : phoneDtos) {
            assertEquals(1, phoneDto.getId());
            assertEquals("name", phoneDto.getName());
            assertEquals("photo", phoneDto.getPhoto());
            assertEquals(BigDecimal.valueOf(1000), phoneDto.getPrice());
            assertEquals("model", phoneDto.getModel());
            assertEquals(ProductType.PHONES.getValue(), phoneDto.getType());
            assertEquals(true, phoneDto.isAvailable());
            assertEquals("10 x 10", phoneDto.getSize());
            assertEquals(100, (int) phoneDto.getWeight());
            assertEquals(10,(int) phoneDto.getStorage());
            assertEquals(10, (int) phoneDto.getRam());
            assertEquals((float)10, phoneDto.getScreen(), 0.0);
            assertEquals("os", phoneDto.getOs());
            assertEquals("color", phoneDto.getColor());
            assertEquals("description", phoneDto.getDescription());
            assertEquals("processor", phoneDto.getProcessor());
            assertEquals("company", phoneDto.getCompany());
            assertEquals(true, phoneDto.isDualSim());
            assertEquals("type", phoneDto.getSimType());
            assertEquals("type", phoneDto.getMessageType());
        }
    }

    @Test
    public void testFromDtoList() {
        List<PhoneDto> phoneDtos = new ArrayList<>();
        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setId(1);
        phoneDto.setName("name");
        phoneDto.setPhoto("photo");
        phoneDto.setPrice(BigDecimal.valueOf(1000));
        phoneDto.setModel("model");
        phoneDto.setType(ProductType.PHONES.getValue());
        phoneDto.setAvailable(true);
        phoneDto.setSize("10 x 10");
        phoneDto.setWeight(100);
        phoneDto.setStorage(10);
        phoneDto.setRam(10);
        phoneDto.setScreen((float)10);
        phoneDto.setOs("os");
        phoneDto.setColor("color");
        phoneDto.setDescription("description");
        phoneDto.setProcessor("processor");
        phoneDto.setCompany("company");
        phoneDto.setDualSim(true);
        phoneDto.setSimType("type");
        phoneDto.setMessageType("type");

        phoneDtos.add(phoneDto);

        List<Phone> phones = phoneMapper.fromDtoList(phoneDtos);

        for(Phone phone : phones) {
            assertEquals(1, phone.getId());
            assertEquals("name", phone.getName());
            assertEquals("photo", phone.getPhoto());
            assertEquals(BigDecimal.valueOf(1000), phone.getPrice());
            assertEquals("model", phone.getModel());
            assertEquals(ProductType.PHONES, phone.getType());
            assertEquals(true, phone.isAvailable());
            assertEquals("10 x 10", phone.getSize());
            assertEquals(100, phone.getWeight());
            assertEquals(10, phone.getStorage());
            assertEquals(10, phone.getRam());
            assertEquals((float)10, phone.getScreen(), 0.0);
            assertEquals("os", phone.getOs());
            assertEquals("color", phone.getColor());
            assertEquals("description", phone.getDescription());
            assertEquals("processor", phone.getProcessor());
            assertEquals("company", phone.getCompany());
            assertEquals(true, phone.isDualSim());
            assertEquals("type", phone.getSimType());
            assertEquals("type", phone.getMessageType());
        }
    }
}
