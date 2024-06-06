package summerbookstore.domain.service.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerbookstore.domain.model.database.Purchase;
import summerbookstore.domain.repository.database.PurchaseRepository;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List <Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public void deleteAll() {
        purchaseRepository.deleteAll();
    }
}
