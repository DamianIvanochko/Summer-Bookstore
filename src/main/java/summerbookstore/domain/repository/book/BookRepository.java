package summerbookstore.domain.repository.book;

import org.springframework.data.jpa.repository.Query;
import summerbookstore.domain.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT url FROM Images", nativeQuery = true)
    List <String> getCoverUrls();
}
