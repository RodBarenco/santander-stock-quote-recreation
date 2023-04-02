package com.project.besantanderstockquoterecreation.controller;

import com.project.besantanderstockquoterecreation.model.dto.StockDTO;
import com.project.besantanderstockquoterecreation.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "https://rodbarenco.github.io");
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "https://rodbarenco.github.io");
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "https://rodbarenco.github.io");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "https://rodbarenco.github.io");
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "https://rodbarenco.github.io");
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "https://rodbarenco.github.io");
        return ResponseEntity.ok(service.findByToday());

    }
}
