package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/user")
public interface UserApi {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTO> updateUserById(@RequestParam Long id, @RequestBody UserDTO userDTO);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTO> findUserById(@PathVariable("id") Long id);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserDTO>> findAllUser();

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long id);
}
