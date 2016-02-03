package com.pigatron.xen.web.rest;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/xen", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class XenController {


    @RequestMapping(value = "/scales", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all scales")
    public List<String> getScales() {
        return new ArrayList<String>();
    }


    @RequestMapping(value = "/scales", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new scale")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The scale was created successfully"),
            @ApiResponse(code = 400, message = "Validation error")})
    public void createScale(@Valid @RequestBody String scale) {
    }

    @RequestMapping(value = "/scales/{id}/select", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Set the currently selected scaleasher53")
    public int selectScale(@PathVariable("id") int id) {
        return id;
    }


}
