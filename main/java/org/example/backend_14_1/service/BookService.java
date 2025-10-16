package org.example.backend_14_1.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend_14_1.exception.FieldNotComplatedException;
import org.example.backend_14_1.model.Book;
import org.example.backend_14_1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class   BookService {


    private final BookRepository bookRepository;


    public void saveBook(Book book) {

        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new FieldNotComplatedException("Author cannot be empty");
        }
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new FieldNotComplatedException("Title cannot be empty");

        }
        if (book.getPrice() == null || book.getPrice() <= 0) {
            throw new FieldNotComplatedException("Price cannot be empty");
        }
        if (book.getDescription() == null || book.getDescription().isEmpty()) {
            throw new FieldNotComplatedException("Description cannot be empty");
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


    public void deleteBook(long id) {
        bookRepository.existById(id);
        if (!bookRepository.existById(id)) {
            throw new IllegalArgumentException("Book with id " + id + " does not exist");
        }

        bookRepository.deleteBook(id);

    }

}
