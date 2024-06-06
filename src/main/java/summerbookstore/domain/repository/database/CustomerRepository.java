package summerbookstore.domain.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerbookstore.domain.model.database.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
