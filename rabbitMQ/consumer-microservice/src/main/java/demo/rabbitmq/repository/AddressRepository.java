package demo.rabbitmq.repository;

import demo.rabbitmq.domain.AddressDocument;
import org.springframework.data.solr.repository.SolrRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends SolrRepository<AddressDocument, Long> {

    AddressDocument findById(Long id);
}
