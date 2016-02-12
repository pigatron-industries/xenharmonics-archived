package com.pigatron.xen.web.rest;

import com.pigatron.xen.domain.entity.Scale;
import com.pigatron.xen.domain.repository.ScaleRepository;
import com.pigatron.xen.domain.entity.ApplicationState;
import com.pigatron.xen.service.ApplicationStateService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/scales", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScaleController
{
    @Autowired
    private ScaleRepository scaleRepository;

    @Autowired
    private ApplicationStateService applicationStateService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all scales")
    public List<Scale> getScales() {
        return scaleRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new scale")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The scale was created successfully"),
            @ApiResponse(code = 400, message = "Validation error")})
    public Scale saveScale(@Valid @RequestBody Scale scale) {
        return scaleRepository.save(scale);
    }


    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete all scales")
    public void deleteScales() {
        scaleRepository.deleteAll();
    }


    @RequestMapping(value = "/selected", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Set the currently selected scale")
    public void setSelectScale(@Valid @RequestBody Scale scale) {
        applicationStateService.setSelectedScale(scale);
    }


    @RequestMapping(value = "/selected", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get the currently selected scale")
    public Scale getSelectedScale() {
        return applicationStateService.getSelectedScale();
    }


}
