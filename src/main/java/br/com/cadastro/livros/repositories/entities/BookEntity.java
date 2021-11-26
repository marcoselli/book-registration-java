package br.com.cadastro.livros.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_LIVROS")
@SequenceGenerator(name = "book_seq", sequenceName = "BOOK_SEQ", initialValue = 1, allocationSize = 1)
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @Column(name = "COD_LIVRO")
    private Long id;

    @Column(name = "DES_TITULO")
    private String title;

    @Column(name = "DES_SUB_TITULO")
    private String caption;

    @Column(name = "DES_RESUMO")
    private String summary;

    @Column(name = "DES_NOME_AUTOR")
    private String authorName;
}
