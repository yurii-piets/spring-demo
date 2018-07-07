package demo.rabbitmq.controller;

import demo.rabbitmq.domain.Customer;
import demo.rabbitmq.repository.CustomerRepository;
import demo.rabbitmq.service.MigrationService;
import demo.rabbitmq.ws.WSCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerRepository customerRepository;

    private final MigrationService migrationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> customer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(c -> ResponseEntity.ok().body(c)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> customer(@RequestBody WSCustomer wsCustomer) {
        Customer customer = wsCustomer.toCustomer();
        customerRepository.save(customer);
        migrationService.migrate(customer);
        return ResponseEntity.accepted().build();
    }
}
