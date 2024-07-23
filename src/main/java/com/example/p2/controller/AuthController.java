package com.example.p2.controller;

import com.example.p2.model.ERole;
import com.example.p2.model.Role;
import com.example.p2.model.User;
import com.example.p2.repository.RoleRepository;
import com.example.p2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/signup")
    public User signup(@RequestBody User userRequest){

        User user = new User(userRequest.getUsername(),
               encoder.encode(userRequest.getPassword())
                , userRequest.getEmail());
        Set<Role> rolesReq=userRequest.getRoles();
        Set<Role> roles=new HashSet<>();
        for (Role role:rolesReq){
           if(role.equals("admin")){
                    roles.add(roleRepository.findByName(ERole.ROLE_ADMIN));
           } else if (role.equals("user")){
                    roles.add(roleRepository.findByName(ERole.ROLE_USER));
           } else if (role.equals("mod")){
               roles.add(roleRepository.findByName(ERole.ROLE_MODERATOR));
           } else {
               roles.add(roleRepository.findByName(ERole.ROLE_USER));
           }

        }


        user.setRoles(roles);
        return userRepository.save(user);

    }
}
