package com.nuuptech.training.inventoryservice.controller;

import com.nuuptech.training.inventoryservice.model.Marca;
import com.nuuptech.training.inventoryservice.service.MarcaService;
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
@RequestMapping(path = "/marca")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Marca> findById(@PathVariable Long id) {
        return new ResponseEntity<>(marcaService.findById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/_listAll",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<List<Marca>> findAll() {
        return new ResponseEntity<>(marcaService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Page<Marca>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity<>(marcaService.findAll(pageable), new HttpHeaders(), HttpStatus.OK);
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
    public ResponseEntity<Marca> createMarca(@RequestBody Marca marca) {
        return new ResponseEntity<>(marcaService.save(marca), new HttpHeaders(), HttpStatus.CREATED);
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
    public ResponseEntity<Marca> updateMarca(@PathVariable Long id, @RequestBody Marca marca) {
        return new ResponseEntity<>(marcaService.update(id, marca), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Boolean> deleteMarca(@PathVariable Long id) {
        return new ResponseEntity<>(marcaService.deleteById(id), new HttpHeaders(), HttpStatus.OK);
    }

}
