package br.com.cadastro.livros.controllers.impl;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.controllers.exception.BookException;
import br.com.cadastro.livros.entities.BookAPI;
import br.com.cadastro.livros.entities.BookController;
import br.com.cadastro.livros.entities.BookModel;
import br.com.cadastro.livros.repositories.BookRepository;
import br.com.cadastro.livros.repositories.entities.BookEntity;
import br.com.cadastro.livros.views.dtos.BookDTO;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BookControlImplTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookControlImpl bookControlImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("MERGE BookControl - Deve salvar o livro corretamente")
    //MERGE - SUCESS
    void ShouldMergeBook() throws BookException {
        when(bookRepository.save(any(BookEntity.class))).thenReturn(BookModel.buildFullBook());
        bookControlImpl.merge(BookController.buildFullBook());
    }

    @Test
    @DisplayName("MERGE BookControl - Excessão de título em branco")
    //MERGE - THROW BOOK EXCEPTION -> Title blank
    void ShouldThrowTitleBlankExceptionWhenMerge() throws BookException {
        Book book = BookController.buildFullBook();
        book.setTitle("");

        when(bookRepository.save(any(BookEntity.class))).thenReturn(null);

        BookException exception = Assertions.assertThrows(BookException.class,
                () -> {bookControlImpl.merge(book);});
        BookException expectedException = new BookException("Nome do título deve estar preenchido.", "title");

        Assertions.assertEquals(expectedException, exception);
    }

    @Test
    @DisplayName("MERGE BookControl - Excessão de subtítulo em branco")
    //MERGE - THROW BOOK EXCEPTION -> Caption blank
    void ShouldThrowCaptionBlankExceptionWhenMerge() throws BookException {
        Book book = BookController.buildFullBook();
        book.setCaption("");

        when(bookRepository.save(any(BookEntity.class))).thenReturn(null);

        BookException exception = Assertions.assertThrows(BookException.class,
                () -> {bookControlImpl.merge(book);});
        BookException expectedException = new BookException(
                "Nome do subtítulo deve estar preenchido.", "caption");

        Assertions.assertEquals(expectedException, exception);
    }

    @Test
    @DisplayName("MERGE BookControl - Excessão de resumo em branco")
    //MERGE - THROW BOOK EXCEPTION -> Summary blank
    void ShouldThrowSummaryBlankExceptionWhenMerge() throws BookException {
        Book book = BookController.buildFullBook();
        book.setSummary("");

        when(bookRepository.save(any(BookEntity.class))).thenReturn(null);

        BookException exception = Assertions.assertThrows(BookException.class,
                () -> {bookControlImpl.merge(book);});
        BookException expectedException = new BookException("O resumo deve estar preenchido.", "summary");

        Assertions.assertEquals(expectedException, exception);
    }

    @Test
    @DisplayName("MERGE BookControl - Excessão de resumo em branco")
    //MERGE - THROW BOOK EXCEPTION -> Author name blank
    void ShouldThrowAuthorNameBlankExceptionWhenMerge() throws BookException {
        Book book = BookController.buildFullBook();
        book.setAuthorName("");

        when(bookRepository.save(any(BookEntity.class))).thenReturn(null);

        BookException exception = Assertions.assertThrows(BookException.class,
                () -> {bookControlImpl.merge(book);});
        BookException expectedException = new BookException(
                "Nome do autor deve estar preenchido.", "authorName");

        Assertions.assertEquals(expectedException, exception);
    }

    @Test
    @DisplayName("DELETE BookControl - Deve deletar o livro corretamente")
    //DELETE - SUCESS
    void ShouldDeleteBook() throws BookException {
        when(bookRepository.findByTitle(anyString())).thenReturn(BookModel.buildFullBook());
        when(bookRepository.delete(anyString())).thenReturn(null);

        Book book = bookControlImpl.delete("abc");
        Book expectedBook = BookController.buildFullBook();

        Assertions.assertEquals(expectedBook, book);
    }

    @Test
    @DisplayName("DELETE BookControl -Excessão de título em branco")
    //DELETE - THROW BOOK EXCEPTION -> Title blank
    void ShouldThrowTitleBlankExceptionWhenDelete() throws BookException {
        when(bookRepository.findByTitle(anyString())).thenReturn(null);
        when(bookRepository.delete(anyString())).thenReturn(null);

        BookException exception = Assertions.assertThrows(BookException.class,
                () -> {bookControlImpl.delete("");});

        BookException expectedException = new BookException("Nome do título deve estar preenchido.", "title");

        Assertions.assertEquals(expectedException, exception);
    }

    /*
    @Test
    @DisplayName("DELETE BookControl - Excessão de livro não encontrado")
    //DELETE - THROW BOOK EXCEPTION -> Book not found
    void ShouldThrowBookNotFoundExceptionWhenDelete() throws BookException {
        //TODO VERIFICAR O MOCK USAR BOOKCONTROLIMP AO INVES DO REPOSITORY NO FIND
        when(bookRepository.findByTitle(anyString()))
                .thenThrow(new BookException("Livro não encontrado.", "title"));
        when(bookRepository.delete(anyString())).thenReturn(null);

        BookException exception = Assertions.assertThrows(BookException.class,
                () -> {bookControlImpl.delete("abc");});

        BookException expectedException = new BookException("Livro não encontrado.", "title");

        Assertions.assertEquals(expectedException, exception);
    }
     */

    @Test
    @DisplayName("FindByTitle Book Control - Deve encontar o livro pelo título corretamente")
    //FindByTitle - SUCESS
    void ShouldFindBookByTitle() throws BookException {
        when(bookRepository.findByTitle(anyString())).thenReturn(BookModel.buildFullBook());

        Book book = bookControlImpl.findByTitle("abc");
        Book expectedBook = BookController.buildFullBook();

        Assertions.assertEquals(expectedBook, book);
    }

    /*
    @Test
    @DisplayName("FindByTitle Book Control - Deve encontar o livro pelo título corretamente")
    //FindByTitle - THROW BOOK EXCEPTION -> Title blank
    void ShouldThrowTitleBlankExceptionWhenFindBookByTitle() throws BookException {
        when(bookRepository.findByTitle(anyString()))
                .thenThrow(new Exception());

        BookException exception = Assertions.assertThrows(BookException.class,
                () -> {bookControlImpl.findByTitle("");});

        BookException expectedException = new BookException("Nome do título deve estar preenchido.", "title");
        Assertions.assertEquals(expectedException, exception);
    }

     */

    @Test
    @DisplayName("FindByAuthor Book Control - Deve encontar o livro pelo nome do autor corretamente")
    void ShouldFindBooksByAuthorName() throws BookException {
        when(bookRepository.findByAuthorName(anyString())).thenReturn(BookModel.buildFullBookList());

        List<Book> bookList = bookControlImpl.findByAuthorName("abc");
        List<Book> expectedList = BookController.buildFullBookList();

        Assertions.assertEquals(expectedList, bookList);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme