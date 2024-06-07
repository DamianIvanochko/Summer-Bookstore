package summerbookstore.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import summerbookstore.domain.model.database.Book;
import summerbookstore.domain.model.database.Purchase;
import summerbookstore.domain.repository.database.BookRepository;
import summerbookstore.domain.repository.database.PurchaseRepository;
import summerbookstore.domain.service.database.BookService;
import summerbookstore.domain.service.database.PurchaseService;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PurchaseServiceTest {
    @Mock
    private PurchaseRepository purchaseRepository;
    @InjectMocks
    private PurchaseService purchaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void savePurchase() {
        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setPurchaseDate(LocalDate.now());

        when(purchaseRepository.save(purchase)).thenReturn(purchase);

        Purchase savedPurchase = purchaseService.save(purchase);

        assertThat(savedPurchase).isNotNull().isEqualTo(purchase);
        assertThat(savedPurchase.getId()).isEqualTo(purchase.getId());
        assertThat(savedPurchase.getPurchaseDate()).isEqualTo(purchase.getPurchaseDate());
    }

    @Test
    void getAllPurchases() {
        Purchase purchase1 = new Purchase();
        purchase1.setId(1L);
        Purchase purchase2 = new Purchase();
        purchase2.setId(2L);

        when(purchaseRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(purchase1, purchase2)));

        purchaseService.save(purchase1);
        purchaseService.save(purchase2);

        assertThat(purchaseService.getAllPurchases()).hasSize(2).contains(purchase1, purchase2);
    }

    @Test
    void deleteAll() {
        doNothing().when(purchaseRepository).deleteAll();

        purchaseService.deleteAll();

        verify(purchaseRepository).deleteAll();
        assertThat(purchaseService.getAllPurchases()).isEqualTo(new ArrayList<>());
    }

    @Test
    void deleteById() {
        Purchase purchase = new Purchase();
        purchase.setId(1L);

        doNothing().when(purchaseRepository).deleteById(1L);

        purchaseService.deleteById(1L);

        verify(purchaseRepository, times(1)).deleteById(1L);
    }

    @Test
    void getById() {
        Purchase purchase = new Purchase();
        purchase.setId(1L);
        purchase.setPurchaseDate(LocalDate.now());
        purchaseService.save(purchase);

        when(purchaseRepository.getById(purchase.getId())).thenReturn(purchase);

        Purchase savedPurchase = purchaseService.getById(purchase.getId());

        assertThat(savedPurchase).isNotNull().isEqualTo(purchase);
        assertThat(savedPurchase.getPurchaseDate()).isEqualTo(purchase.getPurchaseDate());
    }
}
