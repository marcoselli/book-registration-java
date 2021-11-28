package br.com.cadastro.livros.entities;

import br.com.cadastro.livros.controllers.Book;

import java.util.Arrays;
import java.util.List;

public class BookController {

    public static Book buildFullBook(){
        return Book.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build();
    }

    public static List<Book> buildFullBookList(){
        return Arrays.asList(
                Book.builder()
                        .title("O menino do pijama listrado")
                        .caption("Bananinha")
                        .summary("Bananinha")
                        .authorName("John Boyne")
                        .build());
    }
}
