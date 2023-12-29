package com.kaya.kaya01.DTO;

import com.kaya.kaya01.Entity.Location;
import com.kaya.kaya01.Entity.User;
import lombok.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Builder
@Data@Value // Use @Value for immutability
public class UserDTO {

    private Integer id;
    private String code;
    private String name;
    private String email;
    private AdressesDTO adressesDTO;
    private Date dateNaissance;
    private String password;
    private String phoneNumber;
    private SearchDTO search;
    private List<LocationDTO> locations;

    public static UserDTO fromEntity(User user) {
        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .code(user.getCode())
                .name(user.getName())
                .email(user.getEmail())
                .adressesDTO(AdressesDTO.fromEntity(user.getAdresse()))
                .dateNaissance(user.getDateNaissance())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .search(SearchDTO.fromEntity(user.getSearch()))
                .locations(Collections.singletonList(LocationDTO.fromEntity((Location) user.getLocations())))
                .build();
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();

        user.setId(userDTO.getId());
        user.setCode(userDTO.getCode());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAdresse(AdressesDTO.toEntity(userDTO.getAdressesDTO()));
        user.setLocations(Collections.singletonList(LocationDTO.toEntity((LocationDTO) userDTO.getLocations())));

        return user;
    }
}
