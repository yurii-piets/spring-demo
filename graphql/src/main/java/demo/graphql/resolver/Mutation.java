package demo.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import demo.graphql.domain.Author;
import demo.graphql.domain.Book;
import demo.graphql.repository.AuthorRepository;
import demo.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public Book newBook(String title, Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        Book book = new Book();
        book.setTitle(title);
        author.ifPresent(book::setAuthor);
        return bookRepository.save(book);
    }

    public Book updateBookTitle(String newTitle, Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(b -> b.setTitle(newTitle));
        book.ifPresent(bookRepository::save);
        return book.orElse(null);
    }

    public Boolean deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
        return true;
    }

    public Author addNewAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Boolean linkAuthorToBook(Long authorId, Long bookId) {
        Optional<Author> author = authorRepository.findById(bookId);
        Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(b -> author.ifPresent(a -> {
            b.setAuthor(a);
            a.getBooks().add(b);
            authorRepository.save(a);
            bookRepository.save(b);
        }));
        return true;
    }
}
