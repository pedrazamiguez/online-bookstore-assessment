package es.pedrazamiguez.assessment.onlinebookstore.domain.repository;

import es.pedrazamiguez.assessment.onlinebookstore.domain.entity.Book;
import java.util.Optional;

public interface BookRepository {
  Book findById(Long bookId);
}
