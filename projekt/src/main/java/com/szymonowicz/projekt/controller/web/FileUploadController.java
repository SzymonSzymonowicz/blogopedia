package com.szymonowicz.projekt.controller.web;


import com.szymonowicz.projekt.model.Post;
import com.szymonowicz.projekt.service.PostService;
import com.szymonowicz.projekt.storage.StorageFileNotFoundException;
import com.szymonowicz.projekt.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FileUploadController {

    private final StorageService storageService;
    private PostService postService;

    @Autowired
    public FileUploadController(StorageService storageService, PostService postService) {
        this.storageService = storageService;
        this.postService = postService;
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/upload/{id}")
    public String addAttachmentView(
            @PathVariable("id") long postId,
            Model model) {

        Optional<Post> postOptional = postService.getPost(postId);

        if(postOptional.isEmpty())
            return "redirect:/";

        Post post = postOptional.get();

        model.addAttribute(post);

        return "addAttachment";
    }

    @PostMapping("/upload/{id}")
    public String handleFileUpload(
            @PathVariable("id") long postId,
            @RequestParam("file") MultipartFile file,
            Model model) {

        Optional<Post> postOptional = postService.getPost(postId);

        if(postOptional.isEmpty())
            return "redirect:/";

        Post post = postOptional.get();
        model.addAttribute(post);

        postService.addAttachment(postId, file.getOriginalFilename());
        storageService.store(file);

        return "addAttachment";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
