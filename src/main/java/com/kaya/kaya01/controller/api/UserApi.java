package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/user")
public interface UserApi {
    @PostMapping(value = APP_ROOT + "/user/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation( summary= "Créer un nouvel utilisateur", description = "cette methode permettra d'enregistrer de creer un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "utilisateur a été crée avec succès"),
            @ApiResponse(responseCode = "400", description = "echec de la creation de l'utilisateur")
    })
    UserDTO createUser(@RequestBody UserDTO userDTO);

    @PutMapping(value = APP_ROOT +"/user/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Mettre à jour un utilisateu", description = "cette methode permettra  une mise ajour aparti de son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "la mise ajour de l'utilisateur a été effectué avec succès"),
            @ApiResponse(responseCode = "400", description = "la mise ajour de l'utilisateur n'a pas été effectué")
    })
    UserDTO updateUserById(@RequestParam Integer id, @RequestBody UserDTO userDTO);

    @GetMapping(value = APP_ROOT +"/user/{iduser}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Récupérer un utilisateur par ID", description = "cette methode permettra  de chercher un user aparti de son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "utilisateur trouver avec succès"),
            @ApiResponse(responseCode = "404", description = " ID de l'utilisatur n existe pas")
    })
    UserDTO findUserById(@PathVariable("iduser") Integer id);

    @Operation(summary = "Récupérer la liste des utilisateurs", description = "Cette methode permet d afficher la liste des user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "la liste des user / une liste vide")
    })
    @GetMapping(value = APP_ROOT +"/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> findAllUser();

    @DeleteMapping(value = APP_ROOT + "/user/{iddelete}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Supprimer un utilisateu", description = "Cette methode permet de supprimer un user par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user supprimer")
    })
    void  deleteUser(@PathVariable("iddelete") Integer id);
}
