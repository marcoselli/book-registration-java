package br.com.cadastro.livros.views.impl;

import br.com.cadastro.livros.controllers.BookControl;
import br.com.cadastro.livros.views.BookAPI;
import br.com.cadastro.livros.views.dtos.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/books")
public class BookAPIImpl implements BookAPI {

    private BookControl bookControl;

    @Autowired
    public BookAPIImpl(BookControl bookControl) {
        this.bookControl = bookControl;
    }

    @Override
    @PostMapping(value = "/salvar")
    public ResponseEntity merge(@RequestBody BookDTO bookDTO) {
        return null;
    }

    @Override
    @PostMapping(value = "/deletar/{bookTitle}")
    public ResponseEntity delete(@PathVariable String bookTitle) {
        return null;
    }

    @Override
    @GetMapping(value = "/buscar-por-nome-livro/{bookTittle}")
    public ResponseEntity findByTitle(@PathVariable String bookTittle) {
        return null;
    }

    @Override
    @GetMapping(value = "/buscar-por-nome-autor/{bookTittle}")
    public ResponseEntity findByAuthor(@PathVariable String authorName) {
        return null;
    }
}
