package com.angelsofdeath.authorization.controller;

import com.angelsofdeath.authorization.entity.LUCheck;
import com.angelsofdeath.authorization.entity.LUCheckGet;
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

    @GetMapping("/getUbyUidP/{uId}/{password}")
    public String getUserByUserIdPassword(@PathVariable("uId") String uId, @PathVariable("password") String password){
        return "{\n\t\"res\": "+authorizationService.getUserByUserIdPassword(uId, password).toString()+"\n}";
    }

    @PostMapping("/login")
    public User getUser(@RequestBody User user){
        return authorizationService.getUser(user.getLogin(), user.getPassword());
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        return authorizationService.addUser(user.getNickname(), user.getLogin(), user.getPassword());
    }

    @PostMapping(value = "/getLU",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LUCheck> getByLU(@RequestBody LUCheckGet lget){
        return ResponseEntity.ok().body(authorizationService.getByLU(lget.getLogin(), lget.getNickname(), lget.getUserID()));
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
