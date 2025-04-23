package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Profile("testdata")
@ConditionalOnProperty(name = "polar.testdata.enabled", havingValue = "true")
@Component
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "Test Book 1", "Author 1", 9.99);
        var book2 = new Book("1234567892", "Test Book 2", "Author 2", 19.99);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

}
