package demo.rabbitmq.rabbit;

import demo.rabbitmq.domain.AddressDocument;
import demo.rabbitmq.domain.CustomerDocument;
import demo.rabbitmq.message.AddressMessage;
import demo.rabbitmq.message.CustomerMessage;
import demo.rabbitmq.repository.AddressRepository;
import demo.rabbitmq.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void receive(CustomerMessage customer) {
        customerRepository.save(map(customer));
    }

    public void receive(AddressMessage address) {
        addressRepository.save(map(address));
    }

    private CustomerDocument map(CustomerMessage customer) {
        return CustomerDocument.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .addressId(customer.getAddressId())
                .build();
    }

    private AddressDocument map(AddressMessage address) {
        return AddressDocument.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .customerId(address.getCustomerId())
                .build();
    }
}
