package com.szymonowicz.projekt.controller.web;

import com.szymonowicz.projekt.dto.AuthorDTO;
import com.szymonowicz.projekt.dto.CommentDTO;
import com.szymonowicz.projekt.model.Author;
import com.szymonowicz.projekt.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
        AuthorDTO authorDTO = new AuthorDTO();
        model.addAttribute("authorDTO", authorDTO);
        model.addAttribute("message", new String());

        return "registration";
    }

    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute("authorDTO") AuthorDTO authorDTO, Errors errors, Model model){
        if(errors.hasErrors()) {
            //System.out.println(errors);
            model.addAttribute("message", "Fix problems above and check if passwords match");
            return "registration";
        }

        if(authorService.existsByUsername(authorDTO.getUsername())) {
            model.addAttribute("message", "User with that username already exists!");
            return "registration";
        }

        authorService.addNewAuthor(authorDTO);
        model.addAttribute("message", "Successfully created new account!");

        return "registration";
    }
}
