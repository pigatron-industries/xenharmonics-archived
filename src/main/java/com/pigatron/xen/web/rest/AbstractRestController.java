package com.pigatron.xen.web.rest;


import com.google.common.collect.Lists;
import com.pigatron.xen.domain.entity.Scale;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractRestController<T, ID extends Serializable> {

    protected PagingAndSortingRepository<T, ID> repository;

    private String sortProperty;


    public AbstractRestController(PagingAndSortingRepository<T, ID> repository, String sortProperty) {
        this.repository = repository;
        this.sortProperty = sortProperty;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all")
    public List<T> get() {
        Iterable<T> all = repository.findAll(new Sort(Sort.Direction.ASC, sortProperty));
        return Lists.newArrayList(all);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get scale by id")
    public T get(@PathVariable ID id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create or update one")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "saved successfully"),
            @ApiResponse(code = 400, message = "Validation error")})
    public T save(@Valid @RequestBody T scale) {
        return repository.save(scale);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete all")
    public void delete() {
        repository.deleteAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete one")
    public void delete(@PathVariable ID id) {
        repository.delete(id);
    }

}
