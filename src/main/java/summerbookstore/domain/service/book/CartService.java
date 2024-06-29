package summerbookstore.domain.service.book;

import org.springframework.stereotype.Service;
import summerbookstore.domain.model.book.Book;

import java.util.*;

@Service
public class CartService {
    private final List<Book> selectedBooks;

    public CartService() {
        selectedBooks = new ArrayList <>();
    }

    public List <Book> getAllSelectedBooks() {
        return Collections.unmodifiableList(selectedBooks);
    }

    public void addBook(Book book) {
        selectedBooks.add(book);
    }

    public void deleteBook(Book book) {
        selectedBooks.remove(book);
    }
}