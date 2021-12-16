package uz.xtreme.stadio.service;

import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.service.dto.category.CategoryCreate;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryCreate dto);

    void deleteCategory(String slug);

    List<Category> categoriesTree();

    Category getBySlug(String slug);
}
