package summerbookstore.domain.service.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import summerbookstore.domain.model.image.Image;
import summerbookstore.domain.repository.image.ImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public void save(Image image) {
        imageRepository.save(image);
    }

    public List<Image> getAllImages() {
        return new ArrayList <>(imageRepository.findAll());
    }

    public Image findById(Long id) {
        return imageRepository.getById(id);
    }

    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }
}
