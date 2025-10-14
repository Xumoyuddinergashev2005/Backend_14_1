package org.example.backend_13_1.controller;


import lombok.RequiredArgsConstructor;
import org.example.backend_13_1.model.Book;
import org.example.backend_13_1.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("/add")
    public String getBookPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());

        return "book";
    }


}
