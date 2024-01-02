// src/main/java/com/example/library/controller/LibraryController.java

package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "index";
    }

    @PostMapping("/checkout")
    public String checkoutBook(@RequestParam Long bookId) {
        libraryService.checkoutBook(bookId);
        return "redirect:/";
    }
}


