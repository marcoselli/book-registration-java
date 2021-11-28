package br.com.cadastro.livros.views.impl;

import br.com.cadastro.livros.adapters.BookAdapter;
import br.com.cadastro.livros.adapters.BookDTOAdapter;
import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.controllers.BookControl;
import br.com.cadastro.livros.controllers.exception.BookException;
import br.com.cadastro.livros.controllers.utils.BookUtil;
import br.com.cadastro.livros.views.BookAPI;
import br.com.cadastro.livros.views.dtos.BookDTO;
import br.com.cadastro.livros.views.dtos.ResponseErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        try {
            bookControl.merge(BookAdapter.convertBookDTOToBook(bookDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
        } catch (BookException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseErrorDTO.builder()
                            .errorMessage(exception.getMessage())
                            .errorObject("Livro")
                            .build());
        }
    }

    @Override
    @PostMapping(value = "/deletar/{bookTitle}")
    public ResponseEntity delete(@PathVariable String bookTitle) {

        try {
            BookDTO bookDTO = BookDTOAdapter.convertBookToBookDTO(bookControl.delete(bookTitle));
            return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
        }
        catch (BookException exception) {
            if(exception.getMessage().equals("Livro não encontrado."))
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(ResponseErrorDTO.builder()
                                .errorMessage(exception.getMessage())
                                .errorObject("Livro")
                                .build());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseErrorDTO.builder()
                    .errorMessage(exception.getMessage())
                    .errorObject("Livro")
                    .build());
        }
    }

    @Override
    @GetMapping(value = "/buscar-por-nome-livro/{bookTittle}")
    public ResponseEntity findByTitle(@PathVariable String bookTittle) {
        try {
            BookDTO bookDTO = BookDTOAdapter.convertBookToBookDTO(bookControl.findByTitle(bookTittle));
            return ResponseEntity.status(HttpStatus.OK).body(bookDTO);
        } catch (BookException exception) {
            if(exception.getMessage().equals("Livro não encontrado."))
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(ResponseErrorDTO.builder()
                                .errorMessage(exception.getMessage())
                                .errorObject("Livro")
                                .build());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseErrorDTO.builder()
                            .errorMessage(exception.getMessage())
                            .errorObject("Livro")
                            .build());
        }
    }

    @Override
    @GetMapping(value = "/buscar-por-nome-autor/{authorName}")
    public ResponseEntity findByAuthor(@PathVariable String authorName) {
        try {
            List<BookDTO> bookDTOList = BookDTOAdapter
                    .convertBookListToBookDTOList(bookControl.findByAuthorName(authorName));
            return ResponseEntity.status(HttpStatus.OK).body(bookDTOList);
        } catch (BookException exception) {
            if(exception.getMessage().equals("Nenhum livro relacionado ao autor."))
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(ResponseErrorDTO.builder()
                                .errorMessage(exception.getMessage())
                                .errorObject("Livro")
                                .build());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseErrorDTO.builder()
                            .errorMessage(exception.getMessage())
                            .errorObject("Livro")
                            .build());
        }
    }
}
