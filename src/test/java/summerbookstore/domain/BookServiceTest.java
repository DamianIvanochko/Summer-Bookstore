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
import summerbookstore.domain.repository.database.BookRepository;
import summerbookstore.domain.service.database.BookService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveBook() {
        Book book = new Book();
        book.setId(1L);
        book.setName("testBook");
        book.setAuthor("testAuthor");
        book.setPrice(12.22);

        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.save(book);

        assertThat(savedBook).isNotNull().isEqualTo(book);
        assertThat(savedBook.getId()).isEqualTo(book.getId());
        assertThat(savedBook.getName()).isEqualTo(book.getName());
        assertThat(savedBook.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(savedBook.getPrice()).isEqualTo(book.getPrice());
    }

    @Test
    void getAllBooks() {
        Book book1 = new Book();
        book1.setId(1L);
        Book book2 = new Book();
        book2.setId(2L);

        when(bookRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(book1, book2)));

        bookService.save(book1);
        bookService.save(book2);

        assertThat(bookService.getAllBooks()).hasSize(2).contains(book1, book2);
    }

    @Test
    void deleteAll() {
        doNothing().when(bookRepository).deleteAll();

        bookService.deleteAll();

        verify(bookRepository).deleteAll();
        assertThat(bookService.getAllBooks()).isEqualTo(new ArrayList<>());
    }

    @Test
    void deleteById() {
        Book book = new Book();
        book.setId(1L);

        doNothing().when(bookRepository).deleteById(1L);

        bookService.deleteById(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void getById() {
        Book book = new Book("book", "author");
        book.setId(1L);
        bookService.save(book);

        when(bookRepository.getById(book.getId())).thenReturn(book);

        Book bookGotById = bookService.getById(book.getId());

        assertThat(bookGotById).isNotNull().isEqualTo(book);
        assertThat(bookGotById.getName()).isEqualTo(book.getName());
        assertThat(bookGotById.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(bookGotById.getPrice()).isEqualTo(book.getPrice());
    }
}