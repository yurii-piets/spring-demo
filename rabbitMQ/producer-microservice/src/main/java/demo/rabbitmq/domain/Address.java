package demo.rabbitmq.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "customer")
@ToString(exclude = "customer")
@Builder
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addr_id")
    private Long id;

    @Column(name = "addr_country")
    private String country;

    @Column(name = "addr_city")
    private String city;

    @Column(name = "addr_postal_code")
    private Integer postalCode;

    @OneToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;
}
