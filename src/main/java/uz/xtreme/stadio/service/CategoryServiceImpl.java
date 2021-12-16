package uz.xtreme.stadio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.repository.CategoryRepository;
import uz.xtreme.stadio.service.dto.category.CategoryCreate;
import uz.xtreme.stadio.service.mapper.CategoryMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public Category createCategory(CategoryCreate dto) {
        if (repository.existsBySlug(dto.getSlug())) {
            throw new RuntimeException("Slug unique constraint");
        }

        Category category = mapper.asCategory(dto);

        return repository.save(category);
    }

    @Override
    public void deleteCategory(String slug) {
        repository.deleteById(slug);
    }

    @Override
    public List<Category> categoriesTree() {
        return repository.findByParentIsNull();
    }

    @Override
    public Category getBySlug(String slug) {
        return repository.findById(slug).orElseThrow(() -> new RuntimeException("Category not found by id"));
    }

}
