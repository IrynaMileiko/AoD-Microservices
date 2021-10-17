package com.angelsofdeath.adminpanel.controller;


import com.angelsofdeath.adminpanel.entity.Role;
import com.angelsofdeath.adminpanel.entity.User;
import com.angelsofdeath.adminpanel.service.RoleService;
import com.angelsofdeath.adminpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @GetMapping("/{id}")
    public Role getRole(@PathVariable("id") Long roleId) {
        return roleService.getRole(roleId);
    }

    @GetMapping("/priority/{priority}")
    public List<Role> getRolesBelowPriority(@PathVariable("priority") int priority){
        return roleService.getRolesBelowPriority(priority);
    }
}
