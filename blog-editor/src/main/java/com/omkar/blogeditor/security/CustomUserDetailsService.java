package com.omkar.blogeditor.security;

import com.omkar.blogeditor.infra.entity.User;
import com.omkar.blogeditor.infra.model.UserDetailModel;
import com.omkar.blogeditor.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("Incorrect Email");
        }
        return new UserDetailModel(user.get());
    }
}
