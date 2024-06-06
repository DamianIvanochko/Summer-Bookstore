package summerbookstore.domain;

import summerbookstore.domain.model.database.Book;
import summerbookstore.domain.service.database.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SummerBookstoreApplicationTests {
	@Autowired
	private BookService bookService;

	@Test
	void saveBook() {
		Book book = new Book("book", "author");
		Book savedBook = bookService.save(book);

		assertThat(savedBook).isNotNull().isEqualTo(book);
	}

	@Test
	void deleteAllBooks() {
		bookService.deleteAll();

		assertThat(bookService.getAllBooks()).isEqualTo(new ArrayList<>());
	}
}
