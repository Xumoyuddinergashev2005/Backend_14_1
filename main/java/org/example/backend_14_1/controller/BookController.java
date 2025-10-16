package org.example.backend_14_1.controller;


import lombok.RequiredArgsConstructor;
import org.example.backend_14_1.model.Book;
import org.example.backend_14_1.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping()
    public String getBookPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());

        return "book";
    }

    @GetMapping("/add")   // bu shunchaki oynani korish uchun
    public String getBookPage() {

        return "addBook";
    }

    @PostMapping("/{id}")
    public String deleteBook (@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }





    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/book";
    }





}
