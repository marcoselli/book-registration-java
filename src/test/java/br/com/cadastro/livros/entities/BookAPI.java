package br.com.cadastro.livros.entities;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.views.dtos.BookDTO;

import java.util.Arrays;
import java.util.List;

public class BookAPI {

    public static BookDTO buildFullBook(){
        return BookDTO.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build();
    }

    public static List<BookDTO> buildFullBookList(){
        return Arrays.asList(BookDTO.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build());
    }
}
