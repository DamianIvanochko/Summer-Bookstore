package summerbookstore.domain.service.database;

import summerbookstore.domain.model.database.Book;
import summerbookstore.domain.repository.database.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List <Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
