package com.desafio.desafio.controller;

import com.desafio.desafio.domain.FeedbackProcess;
import com.desafio.desafio.service.FeedbackProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("feedbackprocess")
public class FeedbackProcessController {

    @Autowired
    private FeedbackProcessService feedbackProcessService;

    @GetMapping("/getByProcess/{idprocess}")
    public ResponseEntity<List<FeedbackProcess>> getByProcess(@PathVariable("idprocess") long idProcess ) { return ResponseEntity.ok( feedbackProcessService.getByProcess( idProcess ) ); }

    @GetMapping("/getByIdUser/{iduser}")
    public ResponseEntity<List<FeedbackProcess>> getByIdUser(@PathVariable("iduser") long idUser ) { return ResponseEntity.ok( feedbackProcessService.getByIdUser( idUser ) ); }

    @GetMapping("/getByIdUserAndIdProcess/{iduser}/{idprocess}")
    public ResponseEntity<FeedbackProcess> getByIdUserAndIdProcess(@PathVariable("iduser") long idUser, @PathVariable("idprocess") long idProcess ) {
        return ResponseEntity.ok( feedbackProcessService.getByIdUserAndIdProcess( idUser, idProcess ) );
    }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody FeedbackProcess feedbackProcess) {
        feedbackProcessService.insert(feedbackProcess);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody FeedbackProcess feedbackProcess) {
        feedbackProcessService.update(feedbackProcess);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
