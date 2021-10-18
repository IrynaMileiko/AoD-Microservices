package com.angelsofdeath.adminpanel.controller;

import com.angelsofdeath.adminpanel.entity.User;
import com.angelsofdeath.adminpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(@RequestParam String sortColumn, @RequestParam boolean direct, @RequestParam int priority) {
        return userService.getAllUsers(sortColumn, direct, priority);
    }

    @PostMapping("/update")
    public void updateUser(@RequestParam String uid, @RequestParam String login, @RequestParam String password,
                           @RequestParam String roleId, @RequestParam String nickname, @RequestParam String comment){
        userService.updateUser(uid, login, password, roleId, nickname, comment);
    }

    @GetMapping("/login/{login}")
    public User getUserByLogin(@PathVariable("login")String login){
        return userService.getUserByLogin(login);
    }

    @GetMapping("/nickname/{nickname}")
    public User getUserByNickname(@PathVariable("nickname") String nickname){
        return userService.getUserByNickname(nickname);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id")String id){
        userService.deleteUser(id);
    }
}
