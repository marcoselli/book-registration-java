package br.com.cadastro.livros.controllers.impl;

import br.com.cadastro.livros.adapters.BookAdapter;
import br.com.cadastro.livros.adapters.BookEntityAdapter;
import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.controllers.BookControl;
import br.com.cadastro.livros.controllers.exception.BookException;
import br.com.cadastro.livros.controllers.utils.BookUtil;
import br.com.cadastro.livros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookControlImpl implements BookControl {

    private BookRepository bookRepository;

    @Autowired
    public BookControlImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void merge(Book book) throws BookException {
        BookUtil.testAllBookFields(book);
        bookRepository.save(BookEntityAdapter.convertBookToBookEntity(book));
    }

    @Override
    public void delete(String bookTitle) throws BookException {
        BookUtil.testTitleField(bookTitle);
        bookRepository.delete(bookTitle);
    }

    @Override
    public Book findByTitle(String bookTitle) throws BookException {
        BookUtil.testTitleField(bookTitle);
        return BookAdapter.convertBookEntityToBook(bookRepository.findByTitle(bookTitle));
    }

    @Override
    public List<Book> findByAuthorName(String authorName) throws BookException {
        BookUtil.testAuthorNameField(authorName);
        return null;
    }
}
