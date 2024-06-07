package summerbookstore.domain.init;

import summerbookstore.domain.model.image.Image;
import summerbookstore.domain.service.database.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import summerbookstore.domain.service.image.ImageService;

import java.awt.*;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private BookService bookService;
    private ImageService imageService = new ImageService();

    public DatabaseInitializer(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
