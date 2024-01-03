package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/uer")
public interface UserApi {
    @PostMapping(value = APP_ROOT + "/user/creat", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer un nouvel utilisateur", notes = "cette methode permettra d'enregistrer de creer un utilisateur", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "utilisateur a été crée avec succès"),
            @ApiResponse(responseCode = "400", description = "echec de la creation de l'utilisateur")
    })
    UserDTO createUser(@RequestBody UserDTO userDTO);

    @PostMapping(value = APP_ROOT +"/user/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mise ajour d'utlisateur", notes = "cette methode permettra  une mise ajour aparti de son ID", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "la mise ajour de l'utilisateur a été effectué avec succès"),
            @ApiResponse(responseCode = "400", description = "la mise ajour de l'utilisateur n'a pas été effectué")
    })
    UserDTO updateUserById(@RequestParam Integer id, @RequestBody UserDTO userDTO);

    @GetMapping(value = APP_ROOT +"/user/{iduser}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Cherché un utlisateur", notes = "cette methode permettra  de chercher un user aparti de son ID", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "utilisateur trouver avec succès"),
            @ApiResponse(responseCode = "404", description = " ID de l'utilisatur n existe pas")
    })
    UserDTO findUserById(@PathVariable("iduser") Integer id);

    @ApiOperation(value = "Renvoyer la liste de l'utilisateur", notes = "Cette methode permet d afficher la liste des user", responseContainer = "List<UserDTO>")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "la liste des user / une liste vide")
    })
    @GetMapping(value = APP_ROOT +"/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> findAllUser();

    @DeleteMapping(value = APP_ROOT + "/user/{iddelete}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer un user", notes = "Cette methode permet de supprimer un user par son ID", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user supprimer")
    })
    void  deleteUser(@PathVariable("iddelete") Integer id);
}
