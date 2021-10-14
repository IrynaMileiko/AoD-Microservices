package com.angelsofdeath.adminpanel.service;

import com.angelsofdeath.adminpanel.entity.Role;
import com.angelsofdeath.adminpanel.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository = new RoleRepository();

    public Role getRole(Long rId) {
        return roleRepository.getRole(rId);
    }
}
