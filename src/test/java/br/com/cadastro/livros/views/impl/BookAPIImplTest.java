package br.com.cadastro.livros.views.impl;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.controllers.BookControl;
import br.com.cadastro.livros.controllers.exception.BookException;
import br.com.cadastro.livros.entities.BookAPI;
import br.com.cadastro.livros.entities.BookController;
import br.com.cadastro.livros.views.dtos.BookDTO;
import br.com.cadastro.livros.views.dtos.ResponseErrorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class BookAPIImplTest {
    @Mock
    BookControl bookControl;
    @InjectMocks
    BookAPIImpl bookAPIImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("MERGE BookAPI - Salvar corretamente")
    //MERGE - 201 CREATED
    void ShouldMergeBook() throws BookException {
       doNothing().when(bookControl).merge(any(Book.class));
       ResponseEntity response = bookAPIImpl.merge(BookAPI.buildFullBook());

       ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.CREATED)
               .body(BookAPI.buildFullBook());

       Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("MERGE BookAPI - Excessão de título em branco")
    //MERGE - 400 BAD REQUEST
    void ShouldReturnTitleBlankExceptionWhenMerge() throws BookException {
        BookDTO bookDTO = BookAPI.buildFullBook();
        bookDTO.setTitle("");

        doThrow(new BookException("Nome do título deve estar preenchido.", "title"))
                .when(bookControl).merge(any(Book.class));
        ResponseEntity response = bookAPIImpl.merge(bookDTO);

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Nome do título deve estar preenchido.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("MERGE BookAPI - Excessão de subtítulo em branco")
    //MERGE - 400 BAD REQUEST
    void ShouldReturnCaptionBlankExceptionWhenMerge() throws BookException {
        BookDTO bookDTO = BookAPI.buildFullBook();
        bookDTO.setCaption("");

        doThrow(new BookException("Nome do subtítulo deve estar preenchido.", "subtitle"))
                .when(bookControl).merge(any(Book.class));
        ResponseEntity response = bookAPIImpl.merge(bookDTO);

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Nome do subtítulo deve estar preenchido.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("MERGE BookAPI - Excessão de resumo em branco")
    //MERGE - 400 BAD REQUEST
    void ShouldReturnSummaryBlankExceptionWhenMerge() throws BookException {
        BookDTO bookDTO = BookAPI.buildFullBook();
        bookDTO.setSummary("");

        doThrow(new BookException("O resumo deve estar preenchido.", "summary"))
                .when(bookControl).merge(any(Book.class));
        ResponseEntity response = bookAPIImpl.merge(bookDTO);

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("O resumo deve estar preenchido.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("MERGE BookAPI - Excessão de nome do autor em branco")
    //MERGE - 400 BAD REQUEST
    void ShouldReturnAuthorNameBlankExceptionWhenMerge() throws BookException {
        BookDTO bookDTO = BookAPI.buildFullBook();
        bookDTO.setAuthorName("");

        doThrow(new BookException("Nome do autor deve estar preenchido.", "authorName"))
                .when(bookControl).merge(any(Book.class));
        ResponseEntity response = bookAPIImpl.merge(bookDTO);

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Nome do autor deve estar preenchido.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    void testDelete() {
        ResponseEntity result = bookAPIImpl.delete("bookTitle");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindByTitle() {
        ResponseEntity result = bookAPIImpl.findByTitle("bookTittle");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindByAuthor() {
        ResponseEntity result = bookAPIImpl.findByAuthor("authorName");
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme