package br.com.cadastro.livros.repositories;

import br.com.cadastro.livros.repositories.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    BookEntity findByTitle(String title);
    List<BookEntity> findByAuthor(String authorName);

}
