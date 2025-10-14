package org.example.backend_13_1.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend_13_1.model.Book;
import org.example.backend_13_1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;


    public void saveBook(Book book) {

        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");

        }
        if (book.getPrice() == null || book.getPrice() <= 0) {
            throw new IllegalArgumentException("Price cannot be empty");
        }
        if (book.getDescription() == null || book.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }


        bookRepository.saveBook(book);


        log.info("Book saved successfully");


    }

    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

}
