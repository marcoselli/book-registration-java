package br.com.cadastro.livros.views;

import br.com.cadastro.livros.views.dtos.BookDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface BookAPI {

    @ApiOperation(value = "Salvar livro")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Apresenta uma mensagem caso SALVOU o livro"),
            @ApiResponse(code = 400, message = "Quando alguma das regras forem quebradas"),
            @ApiResponse(code = 403, message = "Apresenta uma mensagem quando não tem permissão para essa ação"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity merge(BookDTO bookDTO);

    @ApiOperation(value = "Deletar livro")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Apresenta uma mensagem caso DELETOU o livro"),
            @ApiResponse(code = 400, message = "Quando alguma das regras forem quebradas"),
            @ApiResponse(code = 403, message = "Apresenta uma mensagem quando não tem permissão para essa ação"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity delete(String bookTitle);

    @ApiOperation(value = "Procurar livro pelo título")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Apresenta uma mensagem caso encontrou o livro"),
            @ApiResponse(code = 204, message = "Apresenta uma mensagem caso não encontrou nenhum resultado"),
            @ApiResponse(code = 400, message = "Quando alguma das regras forem quebradas"),
            @ApiResponse(code = 403, message = "Apresenta uma mensagem quando não tem permissão para essa ação"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity findByTitle(String bookTittle);

    @ApiOperation(value = "Listar livros pelo nome do autor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Apresenta uma mensagem caso encontrou todos os livros"),
            @ApiResponse(code = 204, message = "Apresenta uma mensagem caso não encontrou nenhum resultado"),
            @ApiResponse(code = 400, message = "Quando alguma das regras forem quebradas"),
            @ApiResponse(code = 403, message = "Apresenta uma mensagem quando não tem permissão para essa ação"),
            @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuário"),
    })
    ResponseEntity findByAuthor(String authorName);
}
