package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.LocationDTO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/location")
public interface LocationApi {
    @PostMapping(value = APP_ROOT + "/location/creeate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "creer une location", description = "Cette methode permet de faire un enregistrement de location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location enregistré avec succès"),
            @ApiResponse(responseCode = "400", description = "echec de l'enregistrement")
    })
    LocationDTO createLocation(@RequestBody LocationDTO locationDTO);

    @PutMapping(value = APP_ROOT +"/location/{id}/{locationDTO}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "modifier une location", description = "cette methode permet la modification d'une location a parti de l'ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "mise ajour fait avec succès"),
            @ApiResponse(responseCode = "400", description = "la mise ajour à echoué")
    })
    LocationDTO updateLocationById(@PathVariable("id") Long id,@PathVariable("locationDTO") LocationDTO locationDTO);

    @GetMapping(value = APP_ROOT +"/location/{id]}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "trouver une location par ID", description = "cette methode permet de faire resortie la liste de location a parti de l'ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "location trouvé  avec succès"),
            @ApiResponse(responseCode = "404", description = "l'ID n'exite pas")
    })
    LocationDTO findLocationById(@PathVariable("id") Long id);
    @GetMapping(value = APP_ROOT +"/location/{code]}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "trouver une location par son CODE", description = "cette methode permet de faire resortie la liste de location a parti du code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "location trouvé  avec succès"),
            @ApiResponse(responseCode = "404", description = "le code n'exite pas")
    })
    LocationDTO findLocationByCode(@PathVariable("code") String code);
    @GetMapping(value = APP_ROOT +"/location/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Afficher la liste de location", description = "cette methode permet de faire resortie la liste de toute location ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "location trouvé  avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune liste de trouvé")
    })
    List<LocationDTO> findAllLocation();

    @DeleteMapping(value = APP_ROOT +"/location/{id]}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "supprimer une location", description = "cette methode permet de supprimer une location a parti de l'ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "location supprimer avec succès"),
            @ApiResponse(responseCode = "404", description = "l'ID n'exite pas")
    })
    void  deleteLocation(@PathVariable("id") Long id);
}
