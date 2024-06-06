package summerbookstore.domain.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerbookstore.domain.model.database.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
