package summerbookstore.domain.image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import summerbookstore.domain.model.image.Image;
import summerbookstore.domain.repository.image.ImageRepository;
import summerbookstore.domain.service.image.ImageService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ImageServiceTest {
    @Mock
    private ImageRepository imageRepository;
    @InjectMocks
    private ImageService imageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveBook() {
        Image image = new Image();
        image.setId(1L);
        image.setName("testImage");

        when(imageRepository.save(image)).thenReturn(image);

        Image savedImage = imageService.save(image);

        assertThat(savedImage).isNotNull().isEqualTo(image);
        assertThat(savedImage.getId()).isEqualTo(image.getId());
        assertThat(savedImage.getName()).isEqualTo(image.getName());
        assertThat(savedImage.getUrl()).isEqualTo(image.getUrl());
    }

    @Test
    void getAllBooks() {
        Image image1 = new Image();
        image1.setId(1L);
        Image image2 = new Image();
        image2.setId(2L);

        when(imageRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(image1, image2)));

        imageService.save(image1);
        imageService.save(image2);

        assertThat(imageService.getAllImages()).hasSize(2).contains(image1, image2);
    }

    @Test
    void deleteAll() {
        doNothing().when(imageRepository).deleteAll();

        imageService.deleteAll();

        verify(imageRepository).deleteAll();
        assertThat(imageService.getAllImages()).isEqualTo(new ArrayList<>());
    }

    @Test
    void deleteById() {
        Image image = new Image();
        image.setId(1L);

        doNothing().when(imageRepository).deleteById(1L);

        imageService.deleteById(1L);

        verify(imageRepository, times(1)).deleteById(1L);
    }

    @Test
    void getById() {
        Image image = new Image("book", "author");
        image.setId(1L);
        imageService.save(image);

        when(imageRepository.getById(image.getId())).thenReturn(image);

        Image savedBook = imageService.findById(image.getId());

        assertThat(savedBook).isNotNull().isEqualTo(image);
        assertThat(savedBook.getName()).isEqualTo(image.getName());
    }
}
