package uz.xtreme.stadio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.stadio.domain.Category;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CategoryRepository extends JpaRepository<Category, String> {
    boolean existsBySlug(String slug);

    List<Category> findByParentIsNull();

}
