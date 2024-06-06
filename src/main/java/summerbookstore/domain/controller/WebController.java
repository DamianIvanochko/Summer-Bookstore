package summerbookstore.domain.controller;

import summerbookstore.domain.model.image.Image;
import summerbookstore.domain.service.database.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import summerbookstore.domain.service.image.ImageService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {
    @Autowired
    private BookService bookService;
    @Autowired
    private final ImageService imageService;

    public WebController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List <String> bookCoverUrls = imageService.getAllImages()
                                        .stream()
                                        .map(Image::getUrl)
                                        .collect(Collectors.toList());

        model.addAttribute("bookCoverUrls", bookCoverUrls);
        model.addAttribute("title", "Summer Bookstore");
        return "index";
    }
}
