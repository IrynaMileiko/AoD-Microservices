package com.angelsofdeath.authorization.controller;

import com.angelsofdeath.authorization.entity.LUCheck;
import com.angelsofdeath.authorization.entity.User;
import com.angelsofdeath.authorization.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping("/{login}/{password}")
    public User getUser(@PathVariable("login") String login, @PathVariable("password") String password){
        return authorizationService.getUser(login, password);
    }

    @PostMapping("/register")
    public User addUser(@RequestParam String username, @RequestParam String login, @RequestParam String password){
        return authorizationService.addUser(username, login, password);
    }

    @GetMapping(value = "/getLU",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LUCheck> getByLU(@RequestParam String login, @RequestParam String username){
        return ResponseEntity.ok().body(authorizationService.getByLU(login, username));
    }

    @GetMapping(path="/getLogin")
    public ResponseEntity<Boolean> getByLogin(@RequestParam String login){
        HttpHeaders hh = new HttpHeaders();
        hh.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok().headers(hh).body(authorizationService.getUserByLogin(login));
    }

    @GetMapping(path="/getUsername")
    public ResponseEntity<Boolean> getByUsername(@RequestParam String username){
        HttpHeaders hh = new HttpHeaders();
        hh.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok().headers(hh).body(authorizationService.getUserByUsername(username));
    }
}
