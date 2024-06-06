package summerbookstore.domain.service.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerbookstore.domain.model.database.Book;
import summerbookstore.domain.model.database.Customer;
import summerbookstore.domain.repository.database.CustomerRepository;

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
