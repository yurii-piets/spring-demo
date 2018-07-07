package demo.rabbitmq.rabbit;

import demo.rabbitmq.domain.CustomerDocument;
import demo.rabbitmq.message.CustomerMessage;
import demo.rabbitmq.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    @Autowired
    private CustomerRepository customerRepository;

    public void receive(CustomerMessage customer) {
        customerRepository.save(map(customer));
    }

    private CustomerDocument map(CustomerMessage customer) {
        return CustomerDocument.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .addressId(customer.getAddressId())
                .build();
    }
}
