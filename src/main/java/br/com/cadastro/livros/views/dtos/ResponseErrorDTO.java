package br.com.cadastro.livros.views.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseErrorDTO {
    private String errorMessage;
    private String errorObject;
}
