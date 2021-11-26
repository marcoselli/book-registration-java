package br.com.cadastro.livros.repositories;

import br.com.cadastro.livros.repositories.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long>{

    BookEntity findByTitle(String title);
    List<BookEntity> findByAuthorName(String authorName);

}
