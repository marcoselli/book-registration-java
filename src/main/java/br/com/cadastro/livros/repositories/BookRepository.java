package br.com.cadastro.livros.repositories;

import br.com.cadastro.livros.repositories.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long>{

    @Query(
            value = "DELETE FROM BookEntity  as b" +
                    " WHERE b.title = :bookTitle"
    )
    void delete(@Param("bookTitle") String bookTitle);

    BookEntity findByTitle(String title);
    List<BookEntity> findByAuthorName(String authorName);

}
