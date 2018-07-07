package demo.rabbitmq.controller;

import demo.rabbitmq.domain.AddressDocument;
import demo.rabbitmq.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressResource {

    private final AddressRepository addressRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> address(@PathVariable Long id) {
        AddressDocument address = addressRepository.findById(id);
        if (address != null) {
            return ResponseEntity.ok().body(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
