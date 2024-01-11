package com.kaya.kaya01.DTO;

import com.kaya.kaya01.Entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
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
                .locations(user.getLocations().stream().map(LocationDTO::fromEntity).collect(Collectors.toList()))
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
        user.setDateNaissance(userDTO.getDateNaissance());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setSearch(SearchDTO.toEntity(userDTO.getSearch()));
        user.setLocations(userDTO.getLocations().stream().map(LocationDTO::toEntity).collect(Collectors.toList()));

        return user;
    }
}
