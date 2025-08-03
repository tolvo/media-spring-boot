package com.pedro.media.media_manager.controller;

import com.pedro.media.media_manager.model.Book;
import com.pedro.media.media_manager.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Listar todos os livros")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.listAll();
    }

    @Operation(summary = "Procurar um livro por id")
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @Operation(summary = "Adicionar livro")
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @Operation(summary = "Excluir livro")
    @DeleteMapping("/{id}")
    public void delBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    @Operation(summary = "Alterar dados de um livro")
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }
}
