package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.PropertyDTO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.commons.lang3.Validate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/Property")
public interface PropertyApi {
    @PostMapping(value = APP_ROOT+"/property/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Eregistrer une propriété", description = "Cette methode permet la creation d'une nouvelle propriété",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "L'objet Propriété est creer ou modifier",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet Propriété est creer ou modifier"),
            @ApiResponse(responseCode = "400", description = "L'objet proprieté non creer ou modifier")
    })
    PropertyDTO creatProperty(@RequestBody PropertyDTO propertyDTO);




    @GetMapping(value =APP_ROOT+ "/property/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Chercher une propriété", description = "Cette methode permet de chercher propriété par son ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "L'objet Propriété est trouvé",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet Propriété est trouvé avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun objet proprieté trouvé ")
    })
    PropertyDTO findProperTyById(@PathVariable("id") Integer id);


    @GetMapping(value = APP_ROOT+"/property/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Voir toute les propriétés", description = "Cette methode permet l'affichage de toute les propriété ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "la liste des propriétés",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La liste des propriétés"),
    })
    List<PropertyDTO> findAllProperty();


    @PutMapping(value = APP_ROOT+"/property/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Modifier une propriété", description = "Cette methode permet de modifier propriété ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "L'objet Propriété est Modifier avec succès",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet Propriété est Modifier avec succèss"),
            @ApiResponse(responseCode = "400", description = "La modification n'a pas été prise en compte  ")
    })
    PropertyDTO updatePropertyByIdAnd(@PathVariable("id") Integer id,@RequestBody PropertyDTO propertyDTO);

    @DeleteMapping(value = APP_ROOT+"/property/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Supprimer une propriété", description = "Cette methode permet la Suppression d'une propriété ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "L'objet Propriété est Supprimer avec succès",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet Propriété est Supprimer avec succèss"),
            @ApiResponse(responseCode = "400", description = "La Suppression n'a pas été prise en compte  ")
    })
    void deletProperty(@PathVariable Integer id);
}
