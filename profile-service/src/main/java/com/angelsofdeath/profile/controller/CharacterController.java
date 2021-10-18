package com.angelsofdeath.profile.controller;

import com.angelsofdeath.profile.entity.Character;
import com.angelsofdeath.profile.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Character> getUserCharacters(@PathVariable Long id){
        return characterService.getUserCharacters(id.toString());
    }
}
