package demo.graphql.config;

import demo.graphql.repository.AuthorRepository;
import demo.graphql.repository.BookRepository;
import demo.graphql.resolver.AuthorResolver;
import demo.graphql.resolver.BookResolver;
import demo.graphql.resolver.Mutation;
import demo.graphql.resolver.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ResolverConfig {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Bean
    public BookResolver bookRepository() {
        return new BookResolver();
    }

    @Bean
    public AuthorResolver authorResolver() {
        return new AuthorResolver();
    }

    @Bean
    public Query queryResolver() {
        return new Query(authorRepository, bookRepository);
    }

    @Bean
    public Mutation mutationResolver() {
        return new Mutation(authorRepository, bookRepository);
    }
}
