package br.com.cadastro.livros.views.impl;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.controllers.BookControl;
import br.com.cadastro.livros.controllers.exception.BookException;
import br.com.cadastro.livros.entities.BookAPI;
import br.com.cadastro.livros.entities.BookController;
import br.com.cadastro.livros.views.dtos.BookDTO;
import br.com.cadastro.livros.views.dtos.ResponseErrorDTO;
import org.dom4j.DocumentException;
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
    @DisplayName("DELETE BookAPI - Deletar corretamente")
    //DELETE - 201 CREATED
    void ShouldDeleteBook() throws BookException {
        when(bookControl.delete(anyString())).thenReturn(BookController.buildFullBook());
        ResponseEntity response = bookAPIImpl.delete("abc");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.CREATED)
                .body(BookAPI.buildFullBook());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("DELETE BookAPI - Excessão de título em branco")
    //DELETE - 400 BAD REQUEST
    void ShouldReturnTitleBlankExceptionWhenDelete() throws BookException {
        when(bookControl.delete(anyString()))
                .thenThrow(new BookException("Nome do título deve estar preenchido.", "title"));
        ResponseEntity response = bookAPIImpl.delete("");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Nome do título deve estar preenchido.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("DELETE BookAPI - Excessão de livro não encontrado")
    //DELETE - 204 NO CONTENT
    void ShouldReturnBookNotFoundExceptionWhenDelete() throws BookException {
        when(bookControl.delete(anyString()))
                .thenThrow(new BookException("Livro não encontrado.", "title"));
        ResponseEntity response = bookAPIImpl.delete("abc");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Livro não encontrado.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("FindByTitle BookAPI - Deve encontrar o livro corretamente")
    //FindByTitle - 200 OK
    void ShouldFindBookByTitle() throws BookException {
        when(bookControl.findByTitle(anyString())).thenReturn(BookController.buildFullBook());
        ResponseEntity response = bookAPIImpl.findByTitle("abc");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.OK)
                .body(BookAPI.buildFullBook());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("FindByTitle BookAPI - Excessão de título em branco")
    //FindByTitle - 400 BAD REQUEST
    void ShouldReturnTitleBlankExceptionWhenFindByTitle() throws BookException {
        when(bookControl.findByTitle(anyString()))
                .thenThrow(new BookException("Nome do título deve estar preenchido.","title"));
        ResponseEntity response = bookAPIImpl.findByTitle("");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Nome do título deve estar preenchido.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("FindByTitle BookAPI - Excessão de livro não encontrado")
    //FindByTitle - 204 NO CONTENT
    void ShouldReturnBookNotFoundExceptionWhenFindByTitle() throws BookException {
        when(bookControl.findByTitle(anyString()))
                .thenThrow(new BookException("Livro não encontrado.","title"));
        ResponseEntity response = bookAPIImpl.findByTitle("abc");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Livro não encontrado.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("FindByAuthorName BookAPI - Deve encontrar o livro corretamente")
    //FindByAuthorName - 200 OK
    void ShouldFindBookByFindByAuthorName() throws BookException {
        when(bookControl.findByAuthorName(anyString())).thenReturn(BookController.buildFullBookList());
        ResponseEntity response = bookAPIImpl.findByAuthor("abc");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.OK)
                .body(BookAPI.buildFullBookList());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("FindByAuthorName BookAPI - Excessão de título em branco")
    //FindByAuthorName - 400 BAD REQUEST
    void ShouldReturnTitleBlankExceptionWhenFindByAuthorName() throws BookException {
        when(bookControl.findByAuthorName(anyString()))
                .thenThrow(new BookException("Nome do título deve estar preenchido.","title"));
        ResponseEntity response = bookAPIImpl.findByAuthor("");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Nome do título deve estar preenchido.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("FindByAuthorName BookAPI - Excessão de livros não encontrados")
    //FindByAuthorName - 204 NO CONTENT
    void ShouldReturnBooksNotFoundWhenFindByAuthorName() throws BookException {
        when(bookControl.findByAuthorName(anyString()))
                .thenThrow(new BookException("Nenhum livro relacionado ao autor.","title"));
        ResponseEntity response = bookAPIImpl.findByAuthor("");

        ResponseEntity responseExpected = ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseErrorDTO.builder()
                        .errorMessage("Nenhum livro relacionado ao autor.")
                        .errorObject("Livro")
                        .build());

        Assertions.assertEquals(responseExpected, response);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme