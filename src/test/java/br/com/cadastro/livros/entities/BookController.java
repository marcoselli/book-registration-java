package br.com.cadastro.livros.entities;

import br.com.cadastro.livros.controllers.Book;

public class BookController {

    public static Book buildFullBook(){
        return Book.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build();
    }
}
