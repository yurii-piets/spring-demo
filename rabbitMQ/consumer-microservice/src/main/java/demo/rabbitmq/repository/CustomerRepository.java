package demo.rabbitmq.repository;

import demo.rabbitmq.domain.CustomerDocument;
import org.springframework.data.solr.repository.SolrRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends SolrRepository<CustomerDocument, Long> {

    CustomerDocument findById(Long id);

    void save(CustomerDocument customerDocument);

    void deleteById(Long id);
}
