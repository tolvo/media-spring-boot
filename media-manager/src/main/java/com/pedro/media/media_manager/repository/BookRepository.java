package com.pedro.media.media_manager.repository;

import com.pedro.media.media_manager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
