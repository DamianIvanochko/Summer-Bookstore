package summerbookstore.domain.service.book;

import org.springframework.stereotype.Service;
import summerbookstore.domain.model.book.Book;

import java.util.*;

@Service
public class CartService {
    private final Map<Long, String> selectedBooks;

    public CartService() {
        selectedBooks = new HashMap <>();
    }

    public List <Book> getAllSelectedBooks() {
        List <Book> books = new ArrayList <>();

        for (Map.Entry<Long, String> entry : selectedBooks.entrySet()) {
            Book book = new Book(Objects.toString(entry.getKey()), Objects.toString(entry.getValue()));

            books.add(book);
        }

        return books;
    }

    public void addBook(Long id, String name) {
        selectedBooks.put(id, name);
    }

    public void deleteBook(Long id) {
        String removed = selectedBooks.remove(id);

        System.out.println(removed);
    }
}
