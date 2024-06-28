package summerbookstore.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import summerbookstore.domain.model.order.Customer;
import summerbookstore.domain.repository.order.CustomerRepository;
import summerbookstore.domain.service.order.CustomerService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCustomer() {
        Customer customer = new Customer("stepa", "james");
        customer.setId(1L);

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.save(customer);

        assertThat(savedCustomer).isNotNull().isEqualTo(customer);
        assertThat(savedCustomer.getId()).isEqualTo(customer.getId());
        assertThat(savedCustomer.getFirstName()).isEqualTo(customer.getFirstName());
        assertThat(savedCustomer.getLastName()).isEqualTo(customer.getLastName());
        assertThat(savedCustomer.getEmail()).isEqualTo(customer.getEmail());
    }

    @Test
    void getAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        Customer customer2 = new Customer();
        customer2.setId(2L);

        when(customerRepository.findAll()).thenReturn(new ArrayList <>(Arrays.asList(customer1, customer2)));

        customerService.save(customer1);
        customerService.save(customer2);

        assertThat(customerService.getAllCustomers()).hasSize(2).contains(customer1, customer2);
    }

    @Test
    void deleteAll() {
        doNothing().when(customerRepository).deleteAll();

        customerRepository.deleteAll();

        verify(customerRepository).deleteAll();
        assertThat(customerService.getAllCustomers()).isEqualTo(new ArrayList<>());
    }

    @Test
    void deleteById() {
        Customer customer = new Customer();
        customer.setId(1L);

        doNothing().when(customerRepository).deleteById(customer.getId());

        customerService.deleteById(customer.getId());

        verify(customerRepository).deleteById(customer.getId());
        assertThat(customer).isNotIn(customerService.getAllCustomers());
    }

    @Test
    void getById() {
        Customer customer = new Customer("igor", "curry");
        customer.setId(1L);
        customerService.save(customer);

        when(customerRepository.getById(customer.getId())).thenReturn(customer);

        Customer savedCustomer = customerService.getById(customer.getId());

        assertThat(savedCustomer).isNotNull().isEqualTo(customer);
        assertThat(savedCustomer.getFirstName()).isEqualTo(customer.getFirstName());
        assertThat(savedCustomer.getLastName()).isEqualTo(customer.getLastName());
        assertThat(savedCustomer.getEmail()).isEqualTo(customer.getEmail());
    }
}
