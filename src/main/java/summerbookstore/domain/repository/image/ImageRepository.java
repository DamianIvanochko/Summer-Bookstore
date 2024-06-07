package summerbookstore.domain.repository.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import summerbookstore.domain.model.image.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
