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
    private Long id = generate_id();

    private String name;

    private String surname;

    private List<Book> books;

    private static long global_id = 0L;

    private static long generate_id() {
        return global_id++;
    }
}
