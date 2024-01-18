package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.kaya01.Entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;


    @JsonProperty("adressesDTO")
    private AdressesDTO adressesDTO;

    @JsonProperty("dateNaissance")
    private Date dateNaissance;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("search")
    private SearchDTO search;

    @JsonProperty("locations")
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
                .locations(user.getLocations() == null ? null :
                        user.getLocations().stream().map(LocationDTO::fromEntity).collect(Collectors.toList()))
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

        if (userDTO.getLocations() != null) {
            user.setLocations(userDTO.getLocations().stream().map(LocationDTO::toEntity).collect(Collectors.toList()));
        } else {
            user.setLocations(new ArrayList<>());
        }

        return user;
    }





}
