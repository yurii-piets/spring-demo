package demo.rabbitmq.service;

import com.google.common.base.Stopwatch;
import demo.rabbitmq.domain.Address;
import demo.rabbitmq.domain.Customer;
import demo.rabbitmq.message.AddressMessage;
import demo.rabbitmq.message.CustomerMessage;
import demo.rabbitmq.repository.AddressRepository;
import demo.rabbitmq.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class MigrationService {

    private final Logger logger = LogManager.getLogger();

    private final Queue queue;

    private final RabbitTemplate rabbitTemplate;

    private final CustomerRepository customerRepository;

    private final AddressRepository addressRepository;

    @Async
    public void migrate(Customer customer) {
        rabbitTemplate.convertAndSend(queue.getName(), map(customer));
    }

    @Async
    public void migrate() {
        logger.info("Migration started");
        Stopwatch timer = Stopwatch.createUnstarted();
        timer.start();

        migrateCustomers();
        migrateAddresses();

        timer.stop();
        logger.info("Migration finished in [" + timer.elapsed() + "]");
    }

    private void migrateCustomers() {
        Flux.fromIterable(customerRepository.findAll())
                .map(this::map)
                .subscribe(c -> rabbitTemplate.convertAndSend(queue.getName(), c));
    }

    private void migrateAddresses() {
        Flux.fromIterable(addressRepository.findAll())
                .map(this::map)
                .subscribe(c -> rabbitTemplate.convertAndSend(queue.getName(), c));
    }

    private CustomerMessage map(Customer customer) {
        return CustomerMessage.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .addressId(customer.getAddress() != null ? customer.getAddress().getId() : null)
                .build();
    }

    private AddressMessage map(Address address) {
        return AddressMessage.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .customerId(address.getCustomer() != null ? address.getCustomer().getId() : null)
                .build();
    }
}
