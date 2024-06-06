package summerbookstore.domain.service.image;

import org.springframework.stereotype.Service;
import summerbookstore.domain.model.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ImageService {
    List <Image> images = new ArrayList <>();

    public ImageService() {
        images.add(new Image("Harry Potter", "/images/harry_potter.jpg"));
        images.add(new Image("Lord of The Rings", "/images/lord_of_the_rings.jpeg"));
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public List<Image> getAll() {
        return new ArrayList <>(images);
    }

    public Image findByUrl(String url) {
        return images.stream()
                .filter(image -> image.getUrl().equals(url))
                .findAny().get();
    }

    public void remove(String url) {
        images.removeIf(image -> image.getUrl().equals(url));
    }
}
