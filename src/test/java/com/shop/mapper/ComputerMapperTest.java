package com.shop.mapper;

import com.shop.dto.ComputerDto;
import com.shop.entity.Computer;
import com.shop.entity.ProductType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dobodzinskiy on 07.04.2016.
 */
public class ComputerMapperTest {

    private ComputerMapper computerMapper = new ComputerMapper();

    @Test
    public void testFromDto() {
        ComputerDto computerDto = new ComputerDto();

        computerDto.setId(1);
        computerDto.setName("name");
        computerDto.setPhoto("photo");
        computerDto.setPrice(BigDecimal.valueOf(1000));
        computerDto.setModel("model");
        computerDto.setType(ProductType.COMPUTERS.getValue());
        computerDto.setAvailable(true);
        computerDto.setSize("10 x 10");
        computerDto.setWeight(100);
        computerDto.setStorage(10);
        computerDto.setRam(10);
        computerDto.setScreen((float)10);
        computerDto.setOs("os");
        computerDto.setColor("color");
        computerDto.setDescription("description");
        computerDto.setProcessor("processor");
        computerDto.setCompany("company");
        computerDto.setCoolingSystem("cSystem");
        computerDto.setMotherboard("mBoard");

        Computer computer = computerMapper.fromDto(computerDto);

        assertEquals(1, computer.getId());
        assertEquals("name", computer.getName());
        assertEquals("photo", computer.getPhoto());
        assertEquals(BigDecimal.valueOf(1000), computer.getPrice());
        assertEquals("model", computer.getModel());
        assertEquals(ProductType.COMPUTERS, computer.getType());
        assertTrue(computer.isAvailable());
        assertEquals("10 x 10", computer.getSize());
        assertEquals(100, computer.getWeight());
        assertEquals(10, computer.getStorage());
        assertEquals(10, computer.getRam());
        assertEquals(10, computer.getScreen(), 0.0);
        assertEquals("os", computer.getOs());
        assertEquals("color", computer.getColor());
        assertEquals("description", computer.getDescription());
        assertEquals("processor", computer.getProcessor());
        assertEquals("company", computer.getCompany());
        assertEquals("cSystem", computer.getCoolingSystem());
        assertEquals("mBoard", computer.getMotherboard());
    }

    @Test
    public void testToDto() {
        Computer computer = new Computer();

        computer.setId(1);
        computer.setName("name");
        computer.setPhoto("photo");
        computer.setPrice(BigDecimal.valueOf(1000));
        computer.setModel("model");
        computer.setType(ProductType.COMPUTERS);
        computer.setAvailable(true);
        computer.setSize("10 x 10");
        computer.setWeight(100);
        computer.setStorage(10);
        computer.setRam(10);
        computer.setScreen((float)10);
        computer.setOs("os");
        computer.setColor("color");
        computer.setDescription("description");
        computer.setProcessor("processor");
        computer.setCompany("company");
        computer.setCoolingSystem("cSystem");
        computer.setMotherboard("mBoard");

        ComputerDto computerDto = computerMapper.toDto(computer);

        assertEquals(1, computerDto.getId());
        assertEquals("name", computerDto.getName());
        assertEquals("photo", computerDto.getPhoto());
        assertEquals(BigDecimal.valueOf(1000), computerDto.getPrice());
        assertEquals("model", computerDto.getModel());
        assertEquals(ProductType.COMPUTERS.getValue(), computerDto.getType());
        assertTrue(computerDto.isAvailable());
        assertEquals("10 x 10", computerDto.getSize());
        assertEquals(100, (int) computerDto.getWeight());
        assertEquals(10, (int) computerDto.getStorage());
        assertEquals(10, (int) computerDto.getRam());
        assertEquals(10, computerDto.getScreen(), 0.0);
        assertEquals("os", computerDto.getOs());
        assertEquals("color", computerDto.getColor());
        assertEquals("description", computerDto.getDescription());
        assertEquals("processor", computerDto.getProcessor());
        assertEquals("company", computerDto.getCompany());
        assertEquals("cSystem", computerDto.getCoolingSystem());
        assertEquals("mBoard", computerDto.getMotherboard());
    }

    @Test
    public void testToDtoList() {
        List<Computer> computers = new ArrayList<>();
        Computer computer = new Computer();

        computer.setId(1);
        computer.setName("name");
        computer.setPhoto("photo");
        computer.setPrice(BigDecimal.valueOf(1000));
        computer.setModel("model");
        computer.setType(ProductType.COMPUTERS);
        computer.setAvailable(true);
        computer.setSize("10 x 10");
        computer.setWeight(100);
        computer.setStorage(10);
        computer.setRam(10);
        computer.setScreen((float)10);
        computer.setOs("os");
        computer.setColor("color");
        computer.setDescription("description");
        computer.setProcessor("processor");
        computer.setCompany("company");
        computer.setCoolingSystem("cSystem");
        computer.setMotherboard("mBoard");
        computers.add(computer);

        List<ComputerDto> computerDtos = computerMapper.toDtoList(computers);
        for(ComputerDto computerDto : computerDtos) {
            assertEquals(1, computerDto.getId());
            assertEquals("name", computerDto.getName());
            assertEquals("photo", computerDto.getPhoto());
            assertEquals(BigDecimal.valueOf(1000), computerDto.getPrice());
            assertEquals("model", computerDto.getModel());
            assertEquals(ProductType.COMPUTERS.getValue(), computerDto.getType());
            assertTrue(computerDto.isAvailable());
            assertEquals("10 x 10", computerDto.getSize());
            assertEquals(100, (int) computerDto.getWeight());
            assertEquals(10, (int) computerDto.getStorage());
            assertEquals(10, (int) computerDto.getRam());
            assertEquals(10, computerDto.getScreen(), 0.0);
            assertEquals("os", computerDto.getOs());
            assertEquals("color", computerDto.getColor());
            assertEquals("description", computerDto.getDescription());
            assertEquals("processor", computerDto.getProcessor());
            assertEquals("company", computerDto.getCompany());
            assertEquals("cSystem", computerDto.getCoolingSystem());
            assertEquals("mBoard", computerDto.getMotherboard());
        }
    }

    @Test
    public void testFromDtoList() {
        List<ComputerDto> computerDtos = new ArrayList<>();
        ComputerDto computerDto = new ComputerDto();

        computerDto.setId(1);
        computerDto.setName("name");
        computerDto.setPhoto("photo");
        computerDto.setPrice(BigDecimal.valueOf(1000));
        computerDto.setModel("model");
        computerDto.setType(ProductType.COMPUTERS.getValue());
        computerDto.setAvailable(true);
        computerDto.setSize("10 x 10");
        computerDto.setWeight(100);
        computerDto.setStorage(10);
        computerDto.setRam(10);
        computerDto.setScreen((float)10);
        computerDto.setOs("os");
        computerDto.setColor("color");
        computerDto.setDescription("description");
        computerDto.setProcessor("processor");
        computerDto.setCompany("company");
        computerDto.setCoolingSystem("cSystem");
        computerDto.setMotherboard("mBoard");

        computerDtos.add(computerDto);

        List<Computer> computers = computerMapper.fromDtoList(computerDtos);
        for(Computer computer : computers) {
            assertEquals(1, computer.getId());
            assertEquals("name", computer.getName());
            assertEquals("photo", computer.getPhoto());
            assertEquals(BigDecimal.valueOf(1000), computer.getPrice());
            assertEquals("model", computer.getModel());
            assertEquals(ProductType.COMPUTERS, computer.getType());
            assertTrue(computer.isAvailable());
            assertEquals("10 x 10", computer.getSize());
            assertEquals(100, computer.getWeight());
            assertEquals(10, computer.getStorage());
            assertEquals(10, computer.getRam());
            assertEquals(10, computer.getScreen(), 0.0);
            assertEquals("os", computer.getOs());
            assertEquals("color", computer.getColor());
            assertEquals("description", computer.getDescription());
            assertEquals("processor", computer.getProcessor());
            assertEquals("company", computer.getCompany());
            assertEquals("cSystem", computer.getCoolingSystem());
            assertEquals("mBoard", computer.getMotherboard());
        }
    }
}
