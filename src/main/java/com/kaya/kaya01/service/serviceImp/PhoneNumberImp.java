package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.PhoneNumberDTO;
import com.kaya.kaya01.Entity.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PhoneNumberImp {

    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();

    public static List<PhoneNumber> convertToEntityList(List<PhoneNumberDTO> phoneNumberDTOList) {
        return phoneNumberDTOList.stream()
                .map(phoneNumberDTO -> modelMapper.map(phoneNumberDTO, PhoneNumber.class))
                .toList();
    }
}
