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
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/scale", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScaleController extends AbstractRestController<Scale, String> {

    private ApplicationStateService applicationStateService;

    @Autowired
    public ScaleController(ScaleRepository scaleRepository, ApplicationStateService applicationStateService) {
        super(scaleRepository, "name");
        this.applicationStateService = applicationStateService;
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
