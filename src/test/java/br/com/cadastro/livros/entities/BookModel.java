package br.com.cadastro.livros.entities;

import br.com.cadastro.livros.repositories.entities.BookEntity;

import java.util.Arrays;
import java.util.List;

public class BookModel {

    public static BookEntity buildFullBook() {
        return BookEntity.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build();
    }

    public static List<BookEntity> buildFullBookList() {

        return Arrays.asList(BookEntity.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build());
    }
}
