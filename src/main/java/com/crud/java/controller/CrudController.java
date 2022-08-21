package com.crud.java.controller;

import com.crud.java.entity.CrudEntity;
import com.crud.java.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {

    @Autowired
    private CrudRepository repository;

    @GetMapping("/")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody CrudEntity crudEntity) {
        return new ResponseEntity<>(repository.save(crudEntity), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAll(CrudEntity crudEntity) {
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<?> update(@RequestBody CrudEntity crudEntity) {
        repository.save(crudEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
