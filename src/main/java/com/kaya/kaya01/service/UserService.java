package com.kaya.kaya01.service;

import com.kaya.kaya01.DTO.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUserById(Long id,UserDTO userDTO);
    UserDTO findUserById(Long id);
    List<UserDTO> findAllUser();
    void  deleteUser(Long id);


}
