package es.pedrazamiguez.assessment.onlinebookstore.domain.repository;

import es.pedrazamiguez.assessment.onlinebookstore.domain.model.Book;

public interface BookRepository {

  Book findById(Long bookId);

  Book save(Book book);
}
