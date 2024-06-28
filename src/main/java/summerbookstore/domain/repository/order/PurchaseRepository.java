package summerbookstore.domain.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerbookstore.domain.model.order.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
