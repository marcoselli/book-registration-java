package br.com.cadastro.livros.entities;
import br.com.cadastro.livros.repositories.entities.BookEntity;

public class BookRepository {

    public static BookEntity buildFullBook(){
        return BookEntity.builder()
                .title("O menino do pijama listrado")
                .caption("Bananinha")
                .summary("Bananinha")
                .authorName("John Boyne")
                .build();
    }
}
