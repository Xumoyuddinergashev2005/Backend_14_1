package org.example.backend_14_1.mapper;

import org.example.backend_14_1.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String title = rs.getString("title");
        String author = rs.getString("author");
        Double price = rs.getDouble("price");
        String description = rs.getString("description");
        Timestamp createAt = rs.getTimestamp("createAt");

        return new Book(id, title, author, price, description, createAt.toLocalDateTime());
    }
}
