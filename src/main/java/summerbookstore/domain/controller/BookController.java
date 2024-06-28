package summerbookstore.domain.controller;

import org.springframework.web.bind.annotation.*;
import summerbookstore.domain.model.book.Book;
import summerbookstore.domain.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import summerbookstore.domain.service.book.CartService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private final BookService bookService;
    @Autowired
    private final CartService cartService;

    public BookController() {
        bookService = new BookService();
        cartService = new CartService();
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        List <Book> books = bookService.getAllBooks();
        List <String> coverUrls = bookService.getCoverUrls();
        List <Book> booksSelected = cartService.getAllSelectedBooks();

        model.addAttribute("books", books);
        model.addAttribute("selectedBooks", booksSelected);
        model.addAttribute("coverUrls", coverUrls);

        return "index";
    }

    @PostMapping("/book/{bookId}")
    public String addBook(@PathVariable Long bookId) {
        cartService.addBook(bookId, bookService.findById(bookId).getName());

        return "redirect:/books";
    }

    @PostMapping("/book/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
        cartService.deleteBook(bookId);

        return "redirect:/books";
    }
}