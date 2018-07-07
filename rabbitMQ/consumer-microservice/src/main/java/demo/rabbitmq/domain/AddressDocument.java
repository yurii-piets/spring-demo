package demo.rabbitmq.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@NoArgsConstructor
@SolrDocument(solrCoreName = "address", collection = "address")
public class AddressDocument {

    @Id
    @Indexed(name = "id", type = "long")
    private Long id;

    @Indexed(name = "country", type = "string")
    private String country;

    @Indexed(name = "city", type = "string")
    private String city;

    @Indexed(name = "city", type = "integer")
    private Integer postalCode;

    @Indexed(name = "city", type = "integer")
    private Long customerId;
}
