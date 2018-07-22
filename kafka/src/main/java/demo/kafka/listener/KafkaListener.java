package demo.kafka.listener;

import demo.kafka.KafkaApplication;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    private static Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

    @org.springframework.kafka.annotation.KafkaListener(topics = "demo")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info(cr.toString());
    }
}
