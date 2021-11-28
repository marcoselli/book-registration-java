package br.com.cadastro.livros.adapters;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.repositories.entities.BookEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BookEntityAdapter {

    private BookEntityAdapter() {
    }

    public static BookEntity convertBookToBookEntity(Book book){
        return BookEntity.builder()
                .title(book.getTitle())
                .caption(book.getCaption())
                .summary(book.getSummary())
                .authorName(book.getAuthorName())
                .build();
    }

    public static List<BookEntity> convertBookListToBookEntityList(List<Book> bookList){
        return bookList.stream()
                .map(book -> convertBookToBookEntity(book))
                .collect(Collectors.toList());
    }
}
