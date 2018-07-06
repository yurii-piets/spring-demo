package demo.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import demo.graphql.domain.Author;
import demo.graphql.domain.Book;
import demo.graphql.repository.AuthorRepository;
import demo.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public Iterable<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> allAuthors(){
        return authorRepository.findAll();
    }
}
