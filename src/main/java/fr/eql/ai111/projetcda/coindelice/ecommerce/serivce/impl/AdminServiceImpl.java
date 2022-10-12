package fr.eql.ai111.projetcda.coindelice.ecommerce.serivce.impl;

import fr.eql.ai111.projetcda.coindelice.ecommerce.dto.AdminDto;
import fr.eql.ai111.projetcda.coindelice.ecommerce.model.Admin;
import fr.eql.ai111.projetcda.coindelice.ecommerce.repository.AdminRepository;
import fr.eql.ai111.projetcda.coindelice.ecommerce.repository.RoleRepository;
import fr.eql.ai111.projetcda.coindelice.ecommerce.serivce.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }
}
