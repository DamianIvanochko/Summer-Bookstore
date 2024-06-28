package summerbookstore.domain.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerbookstore.domain.model.order.Purchase;
import summerbookstore.domain.repository.order.PurchaseRepository;

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

    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }

    public Purchase getById(Long id) {
        return purchaseRepository.getById(id);
    }
}
