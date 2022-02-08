package com.nuuptech.training.inventoryservice.controller;

import com.nuuptech.training.inventoryservice.model.Sucursal;
import com.nuuptech.training.inventoryservice.service.SucursalService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@CrossOrigin(origins = "*", maxAge = 3600L)
@RestController
@RequestMapping(path = "/sucursal")
public class SucursalController {

    @Autowired
    SucursalService sucursalService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Sucursal> findById(@PathVariable Long id) {
        return new ResponseEntity<>(sucursalService.findById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/_listAll",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<List<Sucursal>> findAll() {
        return new ResponseEntity<>(sucursalService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Page<Sucursal>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity<>(sucursalService.findAll(pageable), new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
        return new ResponseEntity<>(sucursalService.save(sucursal), new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        return new ResponseEntity<>(sucursalService.update(id, sucursal), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Boolean> deleteSucursal(@PathVariable Long id) {
        return new ResponseEntity<>(sucursalService.deleteById(id), new HttpHeaders(), HttpStatus.OK);
    }

}
