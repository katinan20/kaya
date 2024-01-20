package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.AddressDTO;
import com.kaya.kaya01.Entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressImp {

    @Autowired
    static ModelMapper modelMapper;

    public AddressDTO fromEntity(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

    public static Address toEntity(AddressDTO addressDTO) {
        Address address;
        address = modelMapper.map(addressDTO, Address.class);
        return address;
    }

}
