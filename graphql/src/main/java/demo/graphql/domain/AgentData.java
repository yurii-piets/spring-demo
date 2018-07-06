package demo.graphql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "agent")
@Data
@NoArgsConstructor
public class AgentData {

    @Id
    private Long id;

    private String name;

    private Location location;

    @Data
    @NoArgsConstructor
    public class Location {
        private Double longitude;

        private Double latitude;
    }
}
