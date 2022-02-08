package com.nuuptech.training.reservationservice.controller;

import com.nuuptech.training.reservationservice.dto.ConfirmacionDto;
import com.nuuptech.training.reservationservice.dto.ReservacionDto;
import com.nuuptech.training.reservationservice.service.ReservacionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@CrossOrigin(origins = "*", maxAge = 3600L)
@RestController
@RequestMapping(path = "/reservacion")
public class ReservacionController {

    @Autowired
    ReservacionService reservacionService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<ConfirmacionDto> createReservacion(@RequestBody ReservacionDto reservacionDto) {
        return new ResponseEntity<>(reservacionService.reservar(reservacionDto), new HttpHeaders(), HttpStatus.CREATED);
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
    public ResponseEntity<ConfirmacionDto> entregarVehiculo(@PathVariable Long id, @RequestBody ReservacionDto reservacionDto) {
        return new ResponseEntity<>(reservacionService.entregar(id, reservacionDto), new HttpHeaders(), HttpStatus.OK);
    }
}
