package com.example.bookstoreapplication.controller;

import com.example.bookstoreapplication.entity.*;
import com.example.bookstoreapplication.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final SeriesService seriesService;
    private final CoverTypeService coverTypeService;
    private final AgeLimitService ageLimitService;

    public BookController(BookService bookService,
                          AuthorService authorService,
                          PublisherService publisherService,
                          SeriesService seriesService,
                          CoverTypeService coverTypeService,
                          AgeLimitService ageLimitService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.seriesService = seriesService;
        this.coverTypeService = coverTypeService;
        this.ageLimitService = ageLimitService;
    }

    @GetMapping("")
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books/books";
    }

    @GetMapping("new-book")
    public String getAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        List<Publisher> publishers = publisherService.findAll();
        model.addAttribute("publishers", publishers);
        List<Series> series = seriesService.findAll();
        model.addAttribute("series", series);
        List<CoverType> coverTypes = coverTypeService.findAll();
        model.addAttribute("coverTypes", coverTypes);
        List<AgeLimit> ageLimits = ageLimitService.findAll();
        model.addAttribute("ageLimits", ageLimits);
        return "books/add-book-form";
    }

    @PostMapping("new-book")
    public String postAddForm(Book book, RedirectAttributes redirectAttributes) {
        Optional<Book> existing = bookService.add(book);
        if (existing.isPresent()) {
            redirectAttributes.addFlashAttribute("successMessage",
                    "Книга успешно добавлена");
            return "redirect:/books/book-details";
        } else {
            redirectAttributes.addFlashAttribute("dangerMessage",
                    "Что-то пошло не так...");
            return "redirect:/books";
        }

        // Один человек. Всего один. На самом деле этого достаточно.
    }
}
