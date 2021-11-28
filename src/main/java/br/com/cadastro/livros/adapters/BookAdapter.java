package br.com.cadastro.livros.adapters;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.repositories.entities.BookEntity;
import br.com.cadastro.livros.views.dtos.BookDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BookAdapter {

    private BookAdapter() {
    }

    public static Book convertBookDTOToBook(BookDTO bookDTO){
        return Book.builder()
                .title(bookDTO.getTitle())
                .caption(bookDTO.getCaption())
                .summary(bookDTO.getSummary())
                .authorName(bookDTO.getAuthorName())
                .build();
    }

    public static Book convertBookEntityToBook(BookEntity bookEntity){
        return Book.builder()
                .title(bookEntity.getTitle())
                .caption(bookEntity.getCaption())
                .summary(bookEntity.getSummary())
                .authorName(bookEntity.getAuthorName())
                .build();
    }

    public static List<Book> convertBookEntityListToBookList(List<BookEntity> bookEntityList){
        return bookEntityList.stream()
                .map(book -> convertBookEntityToBook(book))
                .collect(Collectors.toList());
    }
}
