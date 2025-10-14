package org.example.backend_14_1.repository;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend_14_1.mapper.BookMapper;
import org.example.backend_14_1.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;


    @PostConstruct
    public void init() {

        String sql = "CREATE TABLE IF NOT EXISTS book (\n" +
                     "    id SERIAL PRIMARY KEY,\n" +
                     "    title VARCHAR(255) NOT NULL,\n" +
                     "    author VARCHAR(255),\n" +
                     "    price NUMERIC(10, 2),\n" +
                     "    description TEXT,\n" +
                     "    createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" +
                     ");\n";
        jdbcTemplate.update(sql);
    }


    public void saveBook(Book book) {

        try {
            String sql = "INSERT INTO book (title, author, price, description) VALUES (?, ?, ?, ?)";


            jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getDescription());
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());

        }
    }

    public void deleteBook(Long id) {
        try {
            String sql = "DELETE FROM book WHERE id = ?";
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());

        }
    }

    public Book getBookById(Long id) {
        String sql = "SELECT * FROM book WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new BookMapper());


    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";


        return jdbcTemplate.query(sql, new BookMapper());
    }


}
