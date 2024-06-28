package summerbookstore.domain.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerbookstore.domain.model.order.Customer;
import summerbookstore.domain.repository.order.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List <Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }
}
