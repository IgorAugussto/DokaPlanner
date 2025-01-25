package com.doka.organizer.controller;

import com.doka.organizer.entity.Ministry;
import com.doka.organizer.service.MinistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ministries")
public class MinistryController {

    @Autowired
    private MinistryService ministryService;

    // Endpoint para cadastrar um novo ministério
    @PostMapping
    public ResponseEntity<Ministry> createMinistry(@RequestBody Ministry ministry) {
        Ministry savedMinistry = ministryService.saveMinistry(ministry);
        return ResponseEntity.ok(savedMinistry);
    }

    // Endpoint para listar todos os ministérios
    @GetMapping
    public ResponseEntity<List<Ministry>> getAllMinistries() {
        return ResponseEntity.ok(ministryService.getAllMinistries());
    }
}
