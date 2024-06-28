package summerbookstore.domain.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerbookstore.domain.model.order.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
