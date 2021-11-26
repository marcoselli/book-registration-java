package br.com.cadastro.livros.views;

import br.com.cadastro.livros.views.dtos.BookDTO;
import org.springframework.http.ResponseEntity;

public interface BookAPI {

    ResponseEntity merge(BookDTO bookDTO);
    ResponseEntity delete(String bookTitle);
    ResponseEntity findByTitle(String bookTittle);
    ResponseEntity findByAuthor(String authorName);
}
