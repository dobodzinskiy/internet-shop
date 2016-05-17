package com.shop.mapper;

import com.shop.dto.PhoneDto;
import com.shop.entity.Phone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("phoneMapper")
public class PhoneMapper implements Mapper<Phone, PhoneDto> {

    @Override
    public Phone fromDto(PhoneDto phoneDto) {
        Phone phone = new Phone();

        phone.setId(phoneDto.getId());
        phone.setName(phoneDto.getName());
        phone.setPhoto(phoneDto.getPhoto());
        phone.setPrice(phoneDto.getPrice());
        phone.setModel(phoneDto.getModel());
        phone.setType(phoneDto.getType());
        phone.setAvailable(phoneDto.isAvailable());
        phone.setSize(phoneDto.getSize());
        phone.setWeight(phoneDto.getWeight());
        phone.setStorage(phoneDto.getStorage());
        phone.setRam(phoneDto.getRam());
        phone.setScreen(phoneDto.getScreen());
        phone.setOs(phoneDto.getOs());
        phone.setColor(phoneDto.getColor());
        phone.setDescription(phoneDto.getDescription());
        phone.setProcessor(phoneDto.getProcessor());
        phone.setCompany(phoneDto.getCompany());
        phone.setDualSim(phoneDto.isDualSim());
        phone.setSimType(phoneDto.getSimType());
        phone.setMessageType(phoneDto.getMessageType());

        return phone;
    }

    @Override
    public PhoneDto toDto(Phone phone) {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setId(phone.getId());
        phoneDto.setName(phone.getName());
        phoneDto.setPhoto(phone.getPhoto());
        phoneDto.setPrice(phone.getPrice());
        phoneDto.setModel(phone.getModel());
        phoneDto.setType(phone.getType());
        phoneDto.setAvailable(phone.isAvailable());
        phoneDto.setSize(phone.getSize());
        phoneDto.setWeight(phone.getWeight());
        phoneDto.setStorage(phone.getStorage());
        phoneDto.setRam(phone.getRam());
        phoneDto.setScreen(phone.getScreen());
        phoneDto.setOs(phone.getOs());
        phoneDto.setColor(phone.getColor());
        phoneDto.setDescription(phone.getDescription());
        phoneDto.setProcessor(phone.getProcessor());
        phoneDto.setCompany(phone.getCompany());
        phoneDto.setDualSim(phone.isDualSim());
        phoneDto.setSimType(phone.getSimType());
        phoneDto.setMessageType(phone.getMessageType());

        return phoneDto;
    }

    @Override
    public List<PhoneDto> toDtoList(List<Phone> phones) {
        List<PhoneDto> phoneDtoList = new ArrayList<>();
        for(Phone phone : phones) {
            phoneDtoList.add(this.toDto(phone));
        }
        return phoneDtoList;
    }

    @Override
    public List<Phone> fromDtoList(List<PhoneDto> phoneDtoList) {
        List<Phone> phones = new ArrayList<>();
        for(PhoneDto phoneDto : phoneDtoList) {
            phones.add(this.fromDto(phoneDto));
        }
        return phones;
    }
}
