package demo.rabbitmq.ws;

import demo.rabbitmq.domain.Address;
import demo.rabbitmq.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSCustomer {

    private Long id;

    private String name;

    private String surname;

    private WSAddress address;

    public WSCustomer(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.surname = customer.getSuranme();
        this.address = customer.getAddress() != null ? new WSAddress(customer.getAddress()) : null;
    }

    public Customer toCustomer() {
        Customer customer = Customer.builder()
                .id(id)
                .name(name)
                .suranme(surname)
                .build();

        if (this.address != null) {
            Address address = this.address.toAddress();
            address.setCustomer(customer);
            customer.setAddress(address);
        }
        return customer;
    }
}
