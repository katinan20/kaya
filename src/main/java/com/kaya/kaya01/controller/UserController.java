package com.kaya.kaya01.controller;

import com.kaya.kaya01.DTO.UserDTO;
import com.kaya.kaya01.controller.api.UserApi;
import com.kaya.kaya01.service.serviceImp.UserServiceIpm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController  implements UserApi {
    private UserServiceIpm userServiceIpm;
    @Autowired
    public UserController(UserServiceIpm userServiceIpmr){
        this.userServiceIpm = userServiceIpmr;
    }
    @Override
    public UserDTO createUser(UserDTO userDTO) {

        return userServiceIpm.createUser(userDTO);
    }

    @Override
    public UserDTO updateUserById(Integer id, UserDTO userDTO) {
        return userServiceIpm.updateUserById(id,userDTO);
    }

    @Override
    public UserDTO findUserById(Integer id) {
        return userServiceIpm.findUserById(id);
    }

    @Override
    public List<UserDTO> findAllUser() {
        return userServiceIpm.findAllUser();
    }

    @Override
    public void deleteUser(Integer id) {
        userServiceIpm.deleteUser(id);
    }
}
