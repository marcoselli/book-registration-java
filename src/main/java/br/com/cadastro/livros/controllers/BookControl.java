package br.com.cadastro.livros.controllers;

import br.com.cadastro.livros.controllers.exception.BookException;

import java.util.List;

public interface BookControl {
    void merge(Book book) throws BookException;
    Book delete(String bookTitle) throws BookException;
    Book findByTitle(String bookTitle) throws BookException;
    List<Book> findByAuthorName(String authorName) throws BookException;
}
