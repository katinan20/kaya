package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.PropertyDTO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;

@Tag(name = "Property API", description = "Operations related to properties")
@Api(APP_ROOT + "/property")
@SecurityRequirement(name = "apiKey")
@RequestMapping(APP_ROOT + "/property")
public interface PropertyApi {

    @PostMapping(value =  "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save a property", description = "This method allows the creation or modification of a new property",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Property object is created or modified",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Property object not created or modified")
            })
    PropertyDTO createProperty(@RequestBody PropertyDTO propertyDTO);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a property", description = "This method allows searching for a property by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Property object is found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "No property object found ")
            })
    PropertyDTO findPropertyById(@PathVariable("id") Long id);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "View all properties", description = "This method allows the display of all properties",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of properties",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
                    @ApiResponse(responseCode = "204", description = "No properties found")
            })
    List<PropertyDTO> findAllProperties();

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a property", description = "This method allows updating a property ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Property object is updated successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Modification not taken into account")
            })
    PropertyDTO updatePropertyById(@PathVariable("id") Long id, @RequestBody PropertyDTO propertyDTO);

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a property", description = "This method allows the deletion of a property ",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Property object is deleted successfully"
                    ),
                    @ApiResponse(responseCode = "404", description = "No property found")
            })
    void deleteProperty(@PathVariable Long id);
}
