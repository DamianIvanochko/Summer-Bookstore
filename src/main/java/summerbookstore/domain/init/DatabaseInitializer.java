package summerbookstore.domain.init;

import summerbookstore.domain.service.book.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import summerbookstore.domain.service.image.ImageService;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final BookService bookService;
    private final ImageService imageService;

    public DatabaseInitializer(BookService bookService, ImageService imageService) {
        this.bookService = bookService;
        this.imageService = imageService;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
