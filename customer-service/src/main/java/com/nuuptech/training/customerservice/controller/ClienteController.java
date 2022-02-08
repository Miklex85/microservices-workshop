package com.nuuptech.training.customerservice.controller;

import com.nuuptech.training.customerservice.model.Cliente;
import com.nuuptech.training.customerservice.service.ClienteService;
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
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.findById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/_listAll",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<List<Cliente>> findAll() {
        return new ResponseEntity<>(clienteService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Page<Cliente>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity<>(clienteService.findAll(pageable), new HttpHeaders(), HttpStatus.OK);
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
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), new HttpHeaders(), HttpStatus.CREATED);
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
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.update(id, cliente), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Boolean> deleteCliente(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.deleteById(id), new HttpHeaders(), HttpStatus.OK);
    }

}
