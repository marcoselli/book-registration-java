package br.com.cadastro.livros.controllers.impl;

import br.com.cadastro.livros.controllers.BookControl;
import br.com.cadastro.livros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookControlImpl implements BookControl {

    private BookRepository bookRepository;

    @Autowired
    public BookControlImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
