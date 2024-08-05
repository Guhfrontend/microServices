package com.devsuperior.hr_worker.controller;

import com.devsuperior.hr_worker.model.Worker;
import com.devsuperior.hr_worker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    private ResponseEntity<List<Worker>> findyall(){
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Worker> findById(@PathVariable Long id){
        return workerRepository.findById(id).map(res -> ResponseEntity.ok(res)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}