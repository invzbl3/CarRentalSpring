package com.project.carrental.service;

import com.project.carrental.entity.User;
import com.project.carrental.repository.UserRepository;
import com.project.carrental.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserDetailsServiceImp(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username was not found.");
        }

        String role = userTypeRepository.findOne(user.getUserTypeID()).getUsertype();
        return new org.springframework.security.core.userdetails
                .User(user.getLogin(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(role)));
    }
}