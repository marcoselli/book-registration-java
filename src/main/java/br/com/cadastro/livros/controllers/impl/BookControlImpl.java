package br.com.cadastro.livros.controllers.impl;

import br.com.cadastro.livros.adapters.BookAdapter;
import br.com.cadastro.livros.adapters.BookEntityAdapter;
import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.controllers.BookControl;
import br.com.cadastro.livros.controllers.exception.BookException;
import br.com.cadastro.livros.controllers.utils.BookUtil;
import br.com.cadastro.livros.repositories.BookRepository;
import br.com.cadastro.livros.repositories.entities.BookEntity;
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
    public Book delete(String bookTitle) throws BookException {
        BookUtil.testTitleField(bookTitle);
        Book book = findByTitle(bookTitle);
        bookRepository.delete(bookRepository.findByTitle(bookTitle));
        return book;
    }

    @Override
    public Book findByTitle(String bookTitle) throws BookException {
        BookUtil.testTitleField(bookTitle);
        try{
            return BookAdapter.convertBookEntityToBook(bookRepository.findByTitle(bookTitle));
        }
        catch (Exception e){
           throw new BookException("Livro não encontrado.", "title");
        }
    }

    @Override
    public List<Book> findByAuthorName(String authorName) throws BookException {
        BookUtil.testAuthorNameField(authorName);

        List<Book> bookList = BookAdapter.convertBookEntityListToBookList(
                bookRepository.findByAuthorName(authorName));

        if(bookList.size() == 0)
            throw new BookException("Nenhum livro relacionado ao autor.","title");

        return bookList;
    }
}
