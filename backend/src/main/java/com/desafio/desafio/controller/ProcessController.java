package com.desafio.desafio.controller;

import com.desafio.desafio.domain.Process;
import com.desafio.desafio.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Process>> getAll() { return ResponseEntity.ok( processService.getAll() ); }

    @GetMapping("/getById/{idprocess}")
    public ResponseEntity<Process> getById( @PathVariable("idprocess") long idProcess ) { return ResponseEntity.ok( processService.getById( idProcess ) ); }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Process process) {
        return ResponseEntity.ok( processService.insert( process ) );
    }
}
