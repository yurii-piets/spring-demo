package demo.graphql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "book")
@Data
@NoArgsConstructor
public class Book {

    @Id
    private Long id = generate_id();

    private String title;

    private Author author;

    private static long global_id = 0L;

    private static long generate_id() {
        return global_id++;
    }
}
