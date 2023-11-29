package com.example.bookstoreapplication.controller;

import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public String findAll(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "authors/authors";
    }

    @GetMapping("new-author")
    public String getAddForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authors/add-author-form";
    }

    @PostMapping("new-author")
    public String postAddForm(Author author, RedirectAttributes redirectAttributes) {
        Optional<Author> newAuthor = authorService.add(author);
        if (newAuthor.isPresent()) {
            redirectAttributes.addFlashAttribute("successMessage",
                    "Автор успешно добавлен!");
        }
        redirectAttributes.addFlashAttribute("dangerMessage",
                "Что-то пошло не так...");
        return "redirect:/authors";
    }
}
