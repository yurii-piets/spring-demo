package demo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private final static String queueName = "migration-queue";

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }
}
