package com.sda.spring.boot.rest.controller;

import com.sda.spring.boot.rest.dto.BookMapper;
import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(BookBetterController.API_BOOKS)
@RestController
public class BookBetterController {

    public static final String API_BOOKS = "/api/books";
    private BookService bookService;

    @Autowired
    public BookBetterController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
        return new ResponseEntity<>(bookService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable(name = "id") Long id) {
        BookResponse response = bookService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@RequestParam(name = "authorName") String authorName) {
        List<BookResponse> books = bookService.findByAuthor(authorName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable(name = "id") Long id,
                                               @RequestBody BookRequest request) {
        BookResponse response = bookService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> partialUpdate(
            @PathVariable(name = "id") Long id,
            @RequestBody BookRequest request) {
        BookResponse response = bookService.partialUpdate(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        bookService.delete(id);
        return new ResponseEntity<>("book deleted", HttpStatus.OK);
    }
}
