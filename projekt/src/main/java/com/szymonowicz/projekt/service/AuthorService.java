package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.dto.AuthorDTO;
import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.model.Comment;
import com.szymonowicz.projekt.model.Role;
import com.szymonowicz.projekt.repository.AuthorRepository;
import com.szymonowicz.projekt.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthorService(AuthorRepository authorRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.authorRepository = authorRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(long id){
        return authorRepository.findById(id);
    }

    public Optional<Author> getAuthorByUsername(String username) {
        return authorRepository.findByUsername(username);
    }

    public void addComment(Author author, Comment saveComment) {
        author.getComments().add(saveComment);
        authorRepository.save(author);
    }

    // returns true if exists, false otherwise
    public boolean existsByUsername(String username) {
        return authorRepository.findByUsername(username).isPresent();
    }

    public void addNewAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());

        if(existsByUsername(authorDTO.getUsername())) {
            log.info("User with username -> " + authorDTO.getUsername() + "<- already exists!");
            return;
        }

        author.setUsername(authorDTO.getUsername());

        Optional<Role> userRole = roleRepository.findByRoleName("USER");
        if (userRole.isEmpty()){
            log.info("Couldn't find role USER");
            return;
        }

        HashSet<Role> roles = new HashSet<>();
        roles.add(userRole.get());
        author.setRoles(roles);

        author.setPassword(passwordEncoder.encode(authorDTO.getPassword()));

        authorRepository.save(author);
    }
}
