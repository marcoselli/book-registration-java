package br.com.cadastro.livros.adapters;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.views.dtos.BookDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BookDTOAdapter {

    private BookDTOAdapter() {
    }

    public static BookDTO convertBookToBookDTO(Book book){
        return BookDTO.builder()
                .title(book.getTitle())
                .caption(book.getCaption())
                .summary(book.getSummary())
                .authorName(book.getAuthorName())
                .build();
    }

    public static List<BookDTO> convertBookListToBookDTOList(List<Book> bookList){
        return bookList.stream()
                .map(book -> convertBookToBookDTO(book))
                .collect(Collectors.toList());
    }
}
