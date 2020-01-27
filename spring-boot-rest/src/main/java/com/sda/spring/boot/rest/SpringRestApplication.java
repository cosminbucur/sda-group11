package com.sda.spring.boot.rest;

import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SpringRestApplication {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class);
    }

    @Bean
    CommandLineRunner data() {
        return args -> bookRepository.saveAll(createBooks());
    }

    private List<Book> createBooks() {
        Book book = new Book();
        book.setTitle("Game of thrones");
        book.setAuthor("George Martin");
        book.setPublished(LocalDate.now());
        return Collections.singletonList(book);
    }
}
