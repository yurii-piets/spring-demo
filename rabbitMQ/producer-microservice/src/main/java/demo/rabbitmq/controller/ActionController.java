package demo.rabbitmq.controller;

import demo.rabbitmq.service.MigrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/action")
public class ActionController {

    private final MigrationService migrationService;

    @PutMapping("/migrate")
    public ResponseEntity<?> migrate(){
        migrationService.migrate();
        return ResponseEntity.accepted().build();
    }
}
