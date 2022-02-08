package com.nuuptech.training.inventoryservice.controller;

import com.nuuptech.training.inventoryservice.model.Vehiculo;
import com.nuuptech.training.inventoryservice.service.VehiculoService;
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
@RequestMapping(path = "/vehiculo")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Vehiculo> findById(@PathVariable Long id) {
        return new ResponseEntity<>(vehiculoService.findById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/_listAll",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<List<Vehiculo>> findAll() {
        return new ResponseEntity<>(vehiculoService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/_getByMarca/{marcaId}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Page<Vehiculo>> findAllByMarca(@PathVariable Long marcaId, @PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity<>(vehiculoService.findAllByMarca(marcaId, pageable), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/_getBySucursal/{sucursalId}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Page<Vehiculo>> findAllBySucursal(@PathVariable Long sucursalId, @PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity<>(vehiculoService.findAllBySucursal(sucursalId, pageable), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Page<Vehiculo>> findByMarcaAndSucursal(@RequestParam(name = "marcaId", required = true) Long marcaId, @RequestParam(name = "sucursalId", required = true) Long sucursalId, @PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity<>(vehiculoService.findAllMarcaAndSucursal(marcaId, sucursalId, pageable), new HttpHeaders(), HttpStatus.OK);
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
    public ResponseEntity<Vehiculo> createVehiculo(@RequestBody Vehiculo vehiculo) {
        return new ResponseEntity<>(vehiculoService.save(vehiculo), new HttpHeaders(), HttpStatus.CREATED);
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
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        return new ResponseEntity<>(vehiculoService.update(id, vehiculo), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Boolean> deleteVehiculo(@PathVariable Long id) {
        return new ResponseEntity<>(vehiculoService.deleteById(id), new HttpHeaders(), HttpStatus.OK);
    }

}
