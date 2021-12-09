package uz.xtreme.stadio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.stadio.domain.Image;

@Repository
@Transactional(readOnly = true)
public interface ImageRepository extends JpaRepository<Image, Long> {
}
