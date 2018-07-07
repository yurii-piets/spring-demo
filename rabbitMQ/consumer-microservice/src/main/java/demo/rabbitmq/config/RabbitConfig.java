package demo.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import demo.rabbitmq.rabbit.RabbitReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private final static String queueName = "migration-queue";

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RabbitReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receive");
    }
}
