package com.shop.mapper;

import com.shop.dto.LaptopDto;
import com.shop.entity.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("laptopMapper")
public class LaptopMapper implements Mapper<Laptop, LaptopDto> {

    @Override
    public Laptop fromDto(LaptopDto laptopDto) {
        Laptop laptop = new Laptop  ();
        laptop.setId(laptopDto.getId());
        laptop.setName(laptopDto.getName());
        laptop.setPhoto(laptopDto.getPhoto());
        laptop.setPrice(laptopDto.getPrice());
        laptop.setModel(laptopDto.getModel());
        laptop.setType(laptopDto.getType());
        laptop.setAvailable(laptopDto.isAvailable());
        laptop.setSize(laptopDto.getSize());
        laptop.setWeight(laptopDto.getWeight());
        laptop.setStorage(laptopDto.getStorage());
        laptop.setRam(laptopDto.getRam());
        laptop.setScreen(laptopDto.getScreen());
        laptop.setOs(laptopDto.getOs());
        laptop.setColor(laptopDto.getColor());
        laptop.setDescription(laptopDto.getDescription());
        laptop.setProcessor(laptopDto.getProcessor());
        laptop.setCompany(laptopDto.getCompany());
        laptop.setKeyboardLight(laptopDto.isKeyboardLight() );

        return laptop;
    }

    @Override
    public LaptopDto toDto(Laptop laptop) {
        LaptopDto laptopDto = new LaptopDto();
        laptopDto.setId(laptop.getId());
        laptopDto.setName(laptop.getName());
        laptopDto.setPhoto(laptop.getPhoto());
        laptopDto.setPrice(laptop.getPrice());
        laptopDto.setModel(laptop.getModel());
        laptopDto.setType(laptop.getType());
        laptopDto.setAvailable(laptop.isAvailable());
        laptopDto.setSize(laptop.getSize());
        laptopDto.setWeight(laptop.getWeight());
        laptopDto.setStorage(laptop.getStorage());
        laptopDto.setRam(laptop.getRam());
        laptopDto.setScreen(laptop.getScreen());
        laptopDto.setOs(laptop.getOs());
        laptopDto.setColor(laptop.getColor());
        laptopDto.setDescription(laptop.getDescription());
        laptopDto.setProcessor(laptop.getProcessor());
        laptopDto.setCompany(laptop.getCompany());
        laptopDto.setKeyboardLight(laptop.isKeyboardLight());

        return laptopDto;
    }

    @Override
    public List<LaptopDto> toDtoList(List<Laptop> laptops) {
        List<LaptopDto> laptopDtos = new ArrayList<>();
        for(Laptop laptop : laptops) {
            laptopDtos.add(this.toDto(laptop));
        }
        return laptopDtos;
    }

    @Override
    public List<Laptop> fromDtoList(List<LaptopDto> laptopDtos) {
        List<Laptop> laptops = new ArrayList<>();
        for(LaptopDto laptopDto : laptopDtos) {
            laptops.add(this.fromDto(laptopDto));
        }
        return laptops;
    }
}
