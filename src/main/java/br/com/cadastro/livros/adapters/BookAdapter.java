package br.com.cadastro.livros.adapters;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.views.dtos.BookDTO;

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
}
