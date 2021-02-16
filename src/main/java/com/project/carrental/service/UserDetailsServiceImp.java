package com.project.carrental.service;

import com.project.carrental.entity.User;
import com.project.carrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository repo;

    @Autowired
    public UserDetailsServiceImp(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
             {
        User user = repo.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username was not found.");
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        if (username.equals("admin")) {
            auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(username, password,
                auth);
    }
}