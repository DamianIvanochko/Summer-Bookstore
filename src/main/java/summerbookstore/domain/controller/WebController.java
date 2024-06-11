package summerbookstore.domain.controller;

import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import summerbookstore.domain.model.database.Book;
import summerbookstore.domain.model.image.Image;
import summerbookstore.domain.service.database.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import summerbookstore.domain.service.image.ImageService;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {
    @Autowired
    private BookService bookService;
    @Autowired
    private final ImageService imageService;

    private List<String> bookListNames = new ArrayList <>();

    public WebController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List <String> bookCoverUrls = getBookCoverUrls();
        List <String> bookNames = getBookNames();
        List <Book> books = bookService.getAllBooks();

        model.addAttribute("bookCoverUrls", bookCoverUrls);
        model.addAttribute("title", "Summer Bookstore");
        model.addAttribute("bookNames", bookNames);
        model.addAttribute("books", books);

        return "index";
    }

    private List<String> getBookCoverUrls() {
        return imageService.getAllImages()
                .stream()
                .map(Image::getUrl)
                .collect(Collectors.toList());
    }

    private List<String> getBookNames() {
        return bookService.getAllBooks()
                .stream()
                .map(Book::getName)
                .collect(Collectors.toList());
    }

    @PostMapping("/addBook")
    public String addToBookList(@RequestParam("bookName") String bookName, Model model) {
        bookListNames.add(bookName);

        model.addAttribute("bookListNames", bookListNames);

        return index(model);
    }

    @PostMapping("/deleteFromList")
    public String removeBookFromList(@RequestParam("bookToRemove") String bookToRemove, Model model) {
        bookListNames.remove(bookToRemove);

        model.addAttribute("bookListNames", bookListNames);

        return index(model);
    }
}
