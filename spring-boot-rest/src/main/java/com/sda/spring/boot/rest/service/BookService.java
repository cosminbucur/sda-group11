package com.sda.spring.boot.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.spring.boot.rest.dto.BookMapper;
import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private BookRepository bookRepository;
    private BookMapper bookMapper;
    private ObjectMapper jacksonObjectMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper, ObjectMapper jacksonObjectMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    // CRUD

    public BookResponse save(BookRequest request) {
        Book book = bookMapper.toEntity(request);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    public List<BookResponse> findAll() {
        log.debug("find all books...");
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDto(books);
    }

    public BookResponse findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));
        return bookMapper.toDto(book);
    }

    public List<BookResponse> findByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return bookMapper.toDto(books);
    }

    public BookResponse update(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        updateFields(request, book);

        Book savedBook = bookRepository.save(book);

        return bookMapper.toDto(savedBook);
    }

    private void updateFields(BookRequest request, Book book) {
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublished(request.getPublished());
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public BookResponse partialUpdate(Long id, BookRequest updates) {
        // find
        try {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("not found"));

            // update

            // Jackson deserializes and copies value to the already initialized DTO
            jacksonObjectMapper.readerForUpdating(book)
                    .readValue(jacksonObjectMapper.writeValueAsBytes(updates));

            // save
            Book updatedBook = bookRepository.save(book);

            // convert
            return bookMapper.toDto(updatedBook);
        } catch (Exception e) {
            log.error("could not patch book with id: {} and updates: {}", id, updates);
        }
        return null;
    }
}
