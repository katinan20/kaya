package com.kaya.kaya01.controller.api;

import com.kaya.kaya01.DTO.LocationDTO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kaya.kaya01.utils.Constants.APP_ROOT;


@Tag(name = "Property Location", description = "Operations related to locations")
@Api(APP_ROOT + "/location")
@SecurityRequirement(name = "apiKey")
@RequestMapping(APP_ROOT + "/location")
public interface LocationApi {

    @PostMapping(value ="/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a location", description = "This method allows the recording of a location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location recorded successfully"),
            @ApiResponse(responseCode = "400", description = "Recording failed")
    })
    LocationDTO createLocation(@RequestBody LocationDTO locationDTO);

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a location", description = "This method allows the modification of a location based on ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update done successfully"),
            @ApiResponse(responseCode = "400", description = "Update failed")
    })
    LocationDTO updateLocationById(@PathVariable("id") Long id, @RequestBody LocationDTO locationDTO);

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a location by ID", description = "This method retrieves the list of locations based on the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location found successfully"),
            @ApiResponse(responseCode = "404", description = "ID does not exist")
    })
    LocationDTO findLocationById(@PathVariable("id") Long id);

    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a location by CODE", description = "This method retrieves the list of locations based on the code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location found successfully"),
            @ApiResponse(responseCode = "404", description = "Code does not exist")
    })
    LocationDTO findLocationByCode(@PathVariable("code") String code);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Display the list of locations", description = "This method retrieves the list of all locations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location list found successfully"),
            @ApiResponse(responseCode = "404", description = "No list found")
    })
    List<LocationDTO> findAllLocation();

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete a location", description = "This method allows the deletion of a location based on ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location deleted successfully"),
            @ApiResponse(responseCode = "404", description = "ID does not exist")
    })
    void deleteLocation(@PathVariable("id") Long id);
}
