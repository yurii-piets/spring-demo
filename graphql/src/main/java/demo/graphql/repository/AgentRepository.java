package demo.graphql.repository;

import demo.graphql.domain.AgentData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends ElasticsearchRepository<AgentData, Long> {

    AgentData findByName(String name);
}
