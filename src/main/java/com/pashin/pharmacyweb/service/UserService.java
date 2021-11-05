package com.pashin.pharmacyweb.service;

import com.pashin.pharmacyweb.model.RoleModel;
import com.pashin.pharmacyweb.model.UserModel;
import com.pashin.pharmacyweb.repository.RoleRepository;
import com.pashin.pharmacyweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel saveUser(UserModel userModel) {
        RoleModel roleModel = roleRepository.findByRoleName("ROLE_USER");
        userModel.setRoleID(roleModel);
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel findByUsernameAndPassword(String username, String password) {
        UserModel userModel = findByUsername(username);
        if (userModel != null) {
            if (passwordEncoder.matches(password, userModel.getPassword())) {
                return userModel;
            }
        }
        return null;
    }

    public RoleModel findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

}
