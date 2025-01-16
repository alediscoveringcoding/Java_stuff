package com.example.demo.controller;

import com.example.demo.dto.EvenimenteDto;
import com.example.demo.models.EvenimenteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RequestMapping("/evenimente")
public interface Evenimente {


    @GetMapping
    ResponseEntity<List<EvenimenteDto>> getEvenimente();

    @PostMapping
    ResponseEntity<EvenimenteEntity> addEveniment(@RequestBody EvenimenteDto evenimenteDto);

    @GetMapping(value = "/eventsByDate/{data}")
    ResponseEntity<List<EvenimenteDto>> getEvenimenteByDate(@PathVariable Date data);

    @GetMapping(value = "/eventsByPlace/{locatie}")
    ResponseEntity<List<EvenimenteDto>> getEvenimenteByLocatie(@PathVariable String locatie);

    @PutMapping(value = "/updateEvent/{id}")
    ResponseEntity<EvenimenteDto> updateEveniment(@PathVariable int id, @RequestBody EvenimenteDto evenimenteDto);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteEveniment(@PathVariable int id);


}
