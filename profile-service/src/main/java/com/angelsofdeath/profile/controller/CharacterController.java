package com.angelsofdeath.profile.controller;

import com.angelsofdeath.profile.entity.CharClass;
import com.angelsofdeath.profile.entity.Character;
import com.angelsofdeath.profile.entity.NewChar;
import com.angelsofdeath.profile.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("{id")
    public Character getCharacter(@PathVariable String id) {
        return characterService.getCharacter(id);
    }

    @GetMapping("/user/{id}")
    public List<Character> getUserCharacters(@PathVariable Long id) {
        return characterService.getUserCharacters(id.toString());
    }

    @GetMapping("/allClasses")
    public List<CharClass> getAllClasses() {
        return characterService.getAllCLasses();
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharByName(@PathVariable String name) {
        HttpHeaders hh = new HttpHeaders();
        hh.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok().headers(hh).body("{\nresult: " + characterService.getCharByName(name) + "\n}");
    }

    @PostMapping("/add")
    public void addCharacter(@RequestBody NewChar ch){
        //characterService.addCharacter(ch.getName(),ch.getClassId(),ch.getDescr(), ch.getUserId());
        System.out.println(ch.toString());
    }
}
