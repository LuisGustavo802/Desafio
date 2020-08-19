package com.desafio.desafio.controller;

import com.desafio.desafio.domain.User;
import com.desafio.desafio.domain.UserSelect;
import com.desafio.desafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() { return ResponseEntity.ok( userService.getAll() ); }

    @GetMapping("/getById/{iduser}")
    public ResponseEntity<User> getById( @PathVariable("iduser") long idUser ) { return ResponseEntity.ok( userService.getById( idUser ) ); }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody User user) {
        userService.insert( user );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody User user) {
        userService.update( user );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{iduser}")
    public ResponseEntity delete(@PathVariable("iduser") Long idUser) {
        userService.delete( idUser );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        return ResponseEntity.ok( userService.login( user ) );
    }

    @GetMapping("/getAllFinalizadores")
    public ResponseEntity<List<UserSelect>> getAllFinalizadores() { return ResponseEntity.ok( userService.getAllFinalizadores() ); }

}