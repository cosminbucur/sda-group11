package com.sda.spring.boot.rest.controller;

import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/books")
    @ResponseBody
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @GetMapping("/books")
    @ResponseBody
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> findById(@PathVariable(name = "id") Long id) {
//        Book book = bookRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException());
//        return new ResponseEntity<>(book, HttpStatus.OK);

        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> update(@PathVariable(name = "id") Long id,
                                       @RequestBody Book newBookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            // find existing book
            Book existingBook = optionalBook.get();

            // update fields
            existingBook.setTitle(newBookDetails.getTitle());
            existingBook.setAuthor(newBookDetails.getAuthor());
            existingBook.setPublished(newBookDetails.getPublished());

            // save the updated book
            bookRepository.save(existingBook);

            // return response
            return new ResponseEntity<>(existingBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("books/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("failed to delete book with id " + id, HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("book deleted successfully", HttpStatus.OK);
    }
}
