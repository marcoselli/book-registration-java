package br.com.cadastro.livros.entities;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.views.dtos.BookDTO;

public class BookAPI {

    public static BookDTO buildFullBook(){
        return BookDTO.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build();
    }
}
