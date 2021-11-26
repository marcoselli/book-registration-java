package br.com.cadastro.livros.views.impl;

import br.com.cadastro.livros.views.BookAPI;
import br.com.cadastro.livros.views.dtos.BookDTO;
import org.springframework.http.ResponseEntity;

public class BookAPIImpl implements BookAPI {
    @Override
    public ResponseEntity merge(BookDTO bookDTO) {
        return null;
    }

    @Override
    public ResponseEntity delete(String bookTitle) {
        return null;
    }

    @Override
    public ResponseEntity findByTitle(String bookTittle) {
        return null;
    }

    @Override
    public ResponseEntity findByAuthor(String authorName) {
        return null;
    }
}
