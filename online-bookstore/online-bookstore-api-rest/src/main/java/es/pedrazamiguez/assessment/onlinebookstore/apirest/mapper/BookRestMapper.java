package es.pedrazamiguez.assessment.onlinebookstore.apirest.mapper;

import es.pedrazamiguez.assessment.onlinebookstore.domain.entity.Book;
import es.pedrazamiguez.assessment.onlinebookstore.openapi.model.BookDto;
import es.pedrazamiguez.assessment.onlinebookstore.openapi.model.BookRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookRestMapper {

  @Mapping(target = "yearPublished", source = "year")
  @Mapping(target = "type.code", source = "type")
  Book toEntity(BookDto bookDto);

  @Mapping(target = "year", source = "yearPublished")
  @Mapping(target = "type", source = "type.code")
  BookDto toDto(Book book);

  @Mapping(target = "yearPublished", source = "year")
  @Mapping(target = "type.code", source = "type")
  Book toEntity(BookRequestDto bookRequestDto);
}
