package es.pedrazamiguez.assessment.onlinebookstore.domain.usecase.book;

import es.pedrazamiguez.assessment.onlinebookstore.domain.entity.Book;

@FunctionalInterface
public interface GetBookDetailsUseCase {
  Book getBookDetails(Long bookId);
}
