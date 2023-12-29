package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;

public interface UserApi {
    @PostMapping(value = APP_ROOT + "/user/creat", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO createUser(@RequestBody UserDTO userDTO);
    @PostMapping(value = APP_ROOT +"/user/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDTO updateUserById(@RequestParam Integer id, @RequestBody UserDTO userDTO);

    @GetMapping(value = APP_ROOT +"/user/{iduser}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO findUserById(@PathVariable("iduser") Integer id);

    @GetMapping(value = APP_ROOT +"/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> findAllUser();

    @DeleteMapping(value = APP_ROOT + "/user/{iddelete}", produces = MediaType.APPLICATION_JSON_VALUE)
    void  deleteUser(@PathVariable("iddelete") Integer id);
}
