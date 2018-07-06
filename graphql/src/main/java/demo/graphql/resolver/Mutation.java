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
}
