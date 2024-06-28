package summerbookstore.domain.repository.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import summerbookstore.domain.model.image.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "SELECT url FROM Images WHERE name = :name", nativeQuery = true)
    String getCoverUrlByName(@Param("name") String name);
}
