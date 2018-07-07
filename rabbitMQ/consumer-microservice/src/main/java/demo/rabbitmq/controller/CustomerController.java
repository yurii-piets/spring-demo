package demo.rabbitmq.controller;

import demo.rabbitmq.domain.CustomerDocument;
import demo.rabbitmq.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> customer(@PathVariable Long id) {
        CustomerDocument customer = customerRepository.findById(id);
        if (customer != null) {
            return ResponseEntity.ok().body(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> customer(@RequestBody CustomerDocument customer) {
        customerRepository.save(customer);
        return ResponseEntity.accepted().build();
    }
}