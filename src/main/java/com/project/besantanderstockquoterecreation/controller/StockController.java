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

@CrossOrigin(origins = "https://rodbarenco.github.io")
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto, HttpServletResponse response){
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(service.save(dto));
    }

    @PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto, HttpServletResponse response){
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(service.update(dto));
    }

    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(HttpServletResponse response){
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id, HttpServletResponse response){
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(service.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id, HttpServletResponse response){
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(service.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(HttpServletResponse response){
        return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(service.findByToday());
    }
}
