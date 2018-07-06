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
    private Long id;

    private String title;

    private Author author;
}
