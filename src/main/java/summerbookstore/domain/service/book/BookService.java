package summerbookstore.domain.service.book;

import summerbookstore.domain.model.book.Book;
import summerbookstore.domain.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
    }

    public List <String> getCoverUrls() {
        return bookRepository.getCoverUrls();
    }
}
