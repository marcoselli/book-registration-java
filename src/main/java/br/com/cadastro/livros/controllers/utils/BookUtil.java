package br.com.cadastro.livros.controllers.utils;

import br.com.cadastro.livros.controllers.Book;
import br.com.cadastro.livros.controllers.exception.BookException;

public class BookUtil {

    public static void testAllBookFields(Book book) throws BookException {
        testTitleField(book.getTitle());
        testCaptionField(book.getCaption());
        testSummaryField(book.getSummary());
        testAuthorNameField(book.getAuthorName());
    }

    private static void testTitleField(String title) throws BookException {
        if(title.isBlank() || title == null)
            throw new BookException("Nome do título deve estar preenchido.", "title");
    }
    private static void testCaptionField(String caption) throws BookException {
        if(caption.isBlank() || caption == null )
            throw new BookException("Nome do subtítulo deve estar preenchido.", "caption");
    }
    private static void testSummaryField(String summary) throws BookException {
        if(summary.isBlank() || summary == null)
            throw new BookException("O resumo deve estar preenchido.", "summary");
    }
    private static void testAuthorNameField(String authorName) throws BookException {
        if(authorName.isBlank() || authorName == null)
            throw new BookException("Nome do autor deve estar preenchido.", "authorName");
    }
}
