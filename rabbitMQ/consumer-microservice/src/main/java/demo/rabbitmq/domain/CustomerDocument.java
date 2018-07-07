package demo.rabbitmq.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@NoArgsConstructor
@SolrDocument(solrCoreName = "customer", collection = "customer")
@Builder
@AllArgsConstructor
public class CustomerDocument {

    @Id
    @Indexed(name = "id", type = "long")
    private Long id;

    @Indexed(name = "name", type = "string")
    private String name;

    @Indexed(name = "surname", type = "string")
    private String surname;

    private Long addressId;
}
