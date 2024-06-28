package summerbookstore.domain.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import summerbookstore.domain.service.book.CartService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CartServiceTest {
    private CartService cartService;

    @BeforeEach
    public void setUp() {
        cartService = new CartService();
    }

//    @Test
//    void deleteBook() {
//        Book book = new Book("book1", "author1");
//
//        cartService.addBook(book.getId(), book.getName());
//
//        assertTrue(cartService.deleteBook(book.getId()));
//        assertFalse(cartService.getAllSelectedBooks().contains(book));
//    }
}
