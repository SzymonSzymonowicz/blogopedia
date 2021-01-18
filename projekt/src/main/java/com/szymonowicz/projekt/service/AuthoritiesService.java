package com.szymonowicz.projekt.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthoritiesService {

    public boolean hasRole(String role){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth instanceof AnonymousAuthenticationToken)
            return false;

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        return authorities.stream()
                .anyMatch(a -> a.getAuthority().equals(role));
    }

    public String getUsername(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }
}
