package br.com.cadastro.livros.controllers.exception;

import lombok.Data;

@Data
public class BookException extends Exception {
    private String fieldName;

    public BookException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
