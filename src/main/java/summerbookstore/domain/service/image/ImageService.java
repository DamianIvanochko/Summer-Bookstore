package summerbookstore.domain.service.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import summerbookstore.domain.model.image.Image;
import summerbookstore.domain.repository.image.ImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image save(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> getAllImages() {
        return new ArrayList <>(imageRepository.findAll());
    }

    public Image findById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

    public void deleteAll() {
        imageRepository.deleteAll();
    }
}
