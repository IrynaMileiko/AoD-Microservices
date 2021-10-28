package com.angelsofdeath.profile.service;

import com.angelsofdeath.profile.entity.CharClass;
import com.angelsofdeath.profile.entity.Character;
import com.angelsofdeath.profile.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    CharacterRepository characterRepository= new CharacterRepository();


    public Character getCharacter(String id) {
        return characterRepository.getCharacter(id);
    }

    public List<Character> getUserCharacters(String id) {
        return characterRepository.getUserCharacters(id);
    }

    public List<CharClass> getAllCLasses() {
        return characterRepository.getAllClasses();
    }

    public Boolean getCharByName(String name) {
        return characterRepository.getCharByName(name);
    }

    public void addCharacter(String name, String classId, String descr, String userId) {
        characterRepository.addCharacter(name,classId,descr, userId);
    }
}
