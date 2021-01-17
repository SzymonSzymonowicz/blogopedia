package com.szymonowicz.projekt.security;

import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<Author> authorOptional = authorRepository.findByUsername(username);

        if (authorOptional.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user");
        }

        Author author = authorOptional.get();
        return new MyUserDetails(author);
    }
}
