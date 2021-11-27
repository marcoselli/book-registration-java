package br.com.cadastro.livros.adapters;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.views.dtos.BookDTO;

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
}
