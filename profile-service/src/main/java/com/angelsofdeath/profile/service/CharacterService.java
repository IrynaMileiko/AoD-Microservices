package com.angelsofdeath.profile.service;

import com.angelsofdeath.profile.entity.CharClass;
import com.angelsofdeath.profile.entity.Character;
import com.angelsofdeath.profile.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    CharacterRepository characterRepository = new CharacterRepository();


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
        characterRepository.addCharacter(name, classId, descr, userId);
    }

    public void deleteCharacter(String chId, String userId) {
        if (isUsersChar(chId, userId))
            characterRepository.deleteCharacter(chId);
    }

    public boolean isUsersChar(String chId, String userId) {
        return characterRepository.isUsersChar(chId, userId);
    }

    public Boolean getCharByNameId(String name, String chId) {
        return characterRepository.getCharByNameId(name, chId);
    }

    public void editCharacter(String chId, String name, String classId, String descr, String userId) {
        if (isUsersChar(chId, userId))
            characterRepository.editCharacter(chId, name, classId, descr);
    }
}
