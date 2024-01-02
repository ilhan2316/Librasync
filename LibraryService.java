// src/main/java/com/example/library/service/LibraryService.java

package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public boolean checkoutBook(Long bookId) {
        // logic to check out a book
        // update book status, record the transaction, etc.
        // For simplicity, let's just set checkedOut to true
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null && !book.isCheckedOut()) {
            book.setCheckedOut(true);
            bookRepository.save(book);
            return true;
        }
        return false; // book not found or already checked out
    }

    // additional methods for handling book check-in, user authentication, etc.
}
