package es.pedrazamiguez.assessment.onlinebookstore.apirest.controller;

import es.pedrazamiguez.assessment.onlinebookstore.openapi.api.BookApi;
import es.pedrazamiguez.assessment.onlinebookstore.openapi.model.BookDto;
import es.pedrazamiguez.assessment.onlinebookstore.openapi.model.BookRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController implements BookApi {
    @Override
    public ResponseEntity<BookDto> addBook(BookRequestDto bookRequestDto) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @Override
    public ResponseEntity<BookDto> getBookById(Long bookId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
