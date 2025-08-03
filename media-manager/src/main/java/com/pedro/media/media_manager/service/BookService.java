package com.pedro.media.media_manager.service;

import com.pedro.media.media_manager.model.Book;
import com.pedro.media.media_manager.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book update(Long id, Book updatedBook) {
        Book existingBook = findById(id);

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setEndReadDate(updatedBook.getEndReadDate());
        existingBook.setStartReadDate(updatedBook.getStartReadDate());
        existingBook.setRate(updatedBook.getRate());

        return bookRepository.saveAndFlush(updatedBook);
    }

    public Book markAsRead(Long id, LocalDate d) {
        Book existingBook = findById(id);

        existingBook.setEndReadDate(d);
        return bookRepository.save(existingBook);
    }
}
