package com.doka.organizer.controller;

import com.doka.organizer.entity.Visitor;
import com.doka.organizer.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Gerenciador das requisições HTTP
@RestController
@RequestMapping("/visitors")
public class VisitorController {

    @Autowired
    private final VisitorService service;

    @PostMapping
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor) {
        return ResponseEntity.ok(service.createVisitor(visitor));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> searchForId(@PathVariable Long id) {
        return service.searchForId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable Long id, @RequestBody Visitor updatedVisitor) {
        try {
            return ResponseEntity.ok(service.updateVisitor(id, updatedVisitor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        service.deleteVisitor(id);
        return ResponseEntity.noContent().build();
    }
}
