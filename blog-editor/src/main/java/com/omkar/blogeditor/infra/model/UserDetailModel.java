package com.omkar.blogeditor.infra.model;

import com.omkar.blogeditor.infra.entity.User;
import javax.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailModel implements UserDetails {

    private String email;
    private String username;
    private String password;
    private boolean active;

    private List<GrantedAuthority> authorities;
    public UserDetailModel(){

    }

    public UserDetailModel(User user){
    this.email=user.getEmail();
    this.username=user.getUsername();
    this.password=user.getPassword();
    this.active=user.isActive();
    this.authorities = Arrays.stream(user.getRole().split(","))
            .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return authorities;}


    public String getEmail() {return email;}

    @Override
    public String getPassword() {return password;}

    @Override
    public String getUsername() {return username;}

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return active;}

    public boolean isActive() {
        return active;
    }
}
