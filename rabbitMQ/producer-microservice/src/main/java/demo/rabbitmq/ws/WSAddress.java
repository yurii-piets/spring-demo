package demo.rabbitmq.ws;

import demo.rabbitmq.domain.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSAddress {

    private Long id;

    private String country;

    private String city;

    private Integer postalCode;

    public WSAddress(Address address) {
        this.id = address.getId();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
    }

    public Address toAddress(){
        return Address.builder()
                .id(id)
                .country(country)
                .city(city)
                .postalCode(postalCode)
                .build();
    }
}
