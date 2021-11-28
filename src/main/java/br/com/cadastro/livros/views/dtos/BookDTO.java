package br.com.cadastro.livros.views.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private String title;
    private String caption;
    private String summary;
    private String authorName;
}
