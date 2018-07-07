package demo.rabbitmq;

import com.google.common.base.Stopwatch;
import demo.rabbitmq.domain.Address;
import demo.rabbitmq.domain.Customer;
import demo.rabbitmq.repository.CustomerRepository;
import demo.rabbitmq.service.MigrationService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LargeDataGenerator implements CommandLineRunner {

    private final static int MAX_CUSTOMERS = 100_000;

    private final Logger logger = LogManager.getLogger();

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MigrationService migrationService;

    @Override
    public void run(String... args) throws Exception {
        //generateCustomersWithTimer();
        migrationService.migrate();
    }

    private void generateCustomersWithTimer() {
        logger.info("Generation started");
        Stopwatch timer = Stopwatch.createUnstarted();
        timer.start();

        generateCustomers();

        timer.stop();
        logger.info("Generation finished in [" + timer.elapsed() + "]");
    }

    private void generateCustomers() {
        for (int i = 1; i < MAX_CUSTOMERS; ++i) {
            Customer customer = randomCustomer(i);
            customerRepository.save(customer);
        }

        Address address = Address.builder()
                .id(0L)
                .city("city")
                .country("country")
                .postalCode(30015)
                .build();
        Customer customer = Customer.builder()
                .id(0L)
                .name("Name")
                .surname("Surname")
                .address(address)
                .build();
        address.setCustomer(customer);
        customerRepository.save(customer);
    }

    private Customer randomCustomer(long i) {
        return Customer.builder()
                .id(i)
                .name(RandomStringUtils.random(10, true, false))
                .surname(RandomStringUtils.random(10, true, false))
                .address(randomAddress(i))
                .build();
    }

    private Address randomAddress(long i) {
        return Address.builder()
                .id(i)
                .country(RandomStringUtils.random(10, true, false))
                .city(RandomStringUtils.random(10, true, false))
                .postalCode(Integer.valueOf(RandomStringUtils.random(5, false, true)))
                .build();
    }
}
