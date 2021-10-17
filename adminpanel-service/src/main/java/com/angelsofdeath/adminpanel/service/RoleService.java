package com.angelsofdeath.adminpanel.service;

import com.angelsofdeath.adminpanel.entity.Role;
import com.angelsofdeath.adminpanel.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository = new RoleRepository();

    public Role getRole(Long rId) {
        return roleRepository.getRole(rId);
    }

    public List<Role> getRolesBelowPriority(int priority) {
        return roleRepository.getRolesBelowPriority(priority);
    }
}
