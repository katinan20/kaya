package com.kaya.kaya01.service;

import com.kaya.kaya01.DTO.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUserById(Integer id,UserDTO userDTO);
    UserDTO findUserById(Integer id);
    List<UserDTO> findAllUser();
    void  deleteUser(Integer id);


}
