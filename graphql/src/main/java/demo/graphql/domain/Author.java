package demo.graphql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "author")
@Data
@NoArgsConstructor
public class Author {

    @Id
    private Long id;

    private String name;

    private String surname;

    private List<Book> books;
}
