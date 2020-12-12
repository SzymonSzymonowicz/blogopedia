package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }



}
