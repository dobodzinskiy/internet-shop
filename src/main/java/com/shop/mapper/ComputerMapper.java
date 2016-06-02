package com.shop.mapper;

import com.shop.dto.ComputerDto;
import com.shop.entity.Computer;
import com.shop.entity.ProductType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("computerMapper")
public class ComputerMapper implements Mapper<Computer, ComputerDto> {

    @Override
    public Computer fromDto(ComputerDto computerDto) {
        Computer computer = new Computer();
        computer.setId(computerDto.getId());
        computer.setName(computerDto.getName());
        computer.setPhoto(computerDto.getPhoto());
        computer.setPrice(computerDto.getPrice());
        computer.setModel(computerDto.getModel());
        computer.setType(ProductType.COMPUTERS);
        computer.setAvailable(computerDto.isAvailable());
        computer.setSize(computerDto.getSize());
        computer.setWeight(computerDto.getWeight());
        computer.setStorage(computerDto.getStorage());
        computer.setRam(computerDto.getRam());
        computer.setScreen(computerDto.getScreen());
        computer.setOs(computerDto.getOs());
        computer.setColor(computerDto.getColor());
        computer.setDescription(computerDto.getDescription());
        computer.setProcessor(computerDto.getProcessor());
        computer.setCompany(computerDto.getCompany());
        computer.setMotherboard(computerDto.getMotherboard());
        computer.setCoolingSystem(computerDto.getCoolingSystem());
        return computer;
    }

    @Override
    public ComputerDto toDto(Computer computer) {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setId(computer.getId());
        computerDto.setName(computer.getName());
        computerDto.setPhoto(computer.getPhoto());
        computerDto.setPrice(computer.getPrice());
        computerDto.setModel(computer.getModel());
        computerDto.setType(ProductType.COMPUTERS.getValue());
        computerDto.setAvailable(computer.isAvailable());
        computerDto.setSize(computer.getSize());
        computerDto.setWeight(computer.getWeight());
        computerDto.setStorage(computer.getStorage());
        computerDto.setRam(computer.getRam());
        computerDto.setScreen(computer.getScreen());
        computerDto.setOs(computer.getOs());
        computerDto.setColor(computer.getColor());
        computerDto.setDescription(computer.getDescription());
        computerDto.setProcessor(computer.getProcessor());
        computerDto.setCompany(computer.getCompany());
        computerDto.setMotherboard(computer.getMotherboard());
        computerDto.setCoolingSystem(computer.getCoolingSystem());
        return computerDto;
    }

    @Override
    public List<ComputerDto> toDtoList(List<Computer> computers) {
        List<ComputerDto> computerDtos = new ArrayList<>();

        for (Computer computer : computers) {
            computerDtos.add(this.toDto(computer));
        }

        return computerDtos;
    }

    @Override
    public List<Computer> fromDtoList(List<ComputerDto> computerDtos) {
        List<Computer> computers = new ArrayList<>();

        for (ComputerDto computerDto : computerDtos) {
            computers.add(this.fromDto(computerDto));
        }

        return computers;
    }
}
