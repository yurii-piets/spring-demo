package demo.rabbitmq.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AddressMessage implements Serializable {
    private Long id;

    private String country;

    private String city;

    private Integer postalCode;

    private Long customerId;
}
