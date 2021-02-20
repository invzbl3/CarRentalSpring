package com.project.carrental.service;

import com.project.carrental.entity.User;
import com.project.carrental.repository.UserRepository;
import com.project.carrental.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository repo;

    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserDetailsServiceImp(UserRepository repo, UserTypeRepository userTypeRepository) {
        this.repo = repo;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
             {
        User user = repo.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username was not found.");
        }

        /*List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        if (username.equals("admin")) {
            auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(username, password,
                auth);
    }*/

    String role = userTypeRepository.findOne(user.getUserTypeID()).getUsertype();
    return new org.springframework.security.core.userdetails
                         .User(user.getLogin(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(role)));
    }
}