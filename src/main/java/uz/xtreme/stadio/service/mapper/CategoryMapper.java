package uz.xtreme.stadio.service.mapper;

import org.springframework.stereotype.Component;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.service.dto.category.CategoryCreate;
import uz.xtreme.stadio.service.dto.category.CategoryTo;
import uz.xtreme.stadio.service.dto.category.NestedCategoryTo;
import uz.xtreme.stadio.service.dto.category.SingleCategoryTo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category asCategory(CategoryCreate dto) {
        if (dto == null)
            return null;

        var category = new Category();

        if (dto.getSlug() != null)
            category.setSlug(dto.getSlug());

        if (dto.getName() != null)
            category.setName(dto.getName());

        if (dto.getParentSlug() != null)
            category.setParent(asCategory(dto.getParentSlug()));

        return category;
    }

    public CategoryTo asDto(Category category) {
        if (category == null)
            return null;

        var dto = new CategoryTo();

        dto.setSlug(category.getSlug());
        dto.setName(category.getName());
        dto.setParent(asDto(category.getParent()));
        dto.setCategories(asDto(category.getCategories()));

        return dto;
    }

    public List<CategoryTo> asDto(List<Category> categories) {
        if (categories == null)
            return Collections.emptyList();

        return categories.stream().map(this::asDto).collect(Collectors.toList());
    }

    public Category asCategory(String slug) {
        if (slug == null)
            return null;

        var category = new Category();

        category.setSlug(slug);

        return category;
    }

    public NestedCategoryTo asNestedCategory(Category category) {
        if (category == null)
            return null;

        var result = new NestedCategoryTo();

        result.setSlug(category.getSlug());
        result.setName(category.getName());
        result.setCategories(asNestedCategory(category.getCategories()));

        return result;
    }

    public List<NestedCategoryTo> asNestedCategory(List<Category> tree) {
        if (tree == null)
            return Collections.emptyList();

        return tree.stream().map(this::asNestedCategory).collect(Collectors.toList());
    }

    public SingleCategoryTo asSingleCategory(Category category) {
        if (category == null)
            return null;

        var result = new SingleCategoryTo();

        result.setSlug(category.getSlug());
        result.setName(category.getName());
        if (category.getParent() != null)
            result.setParentSlug(category.getParent().getSlug());

        return result;
    }

    public List<SingleCategoryTo> asSingleCategory(List<Category> category) {
        if (category == null)
            return Collections.emptyList();

        return category.stream().map(this::asSingleCategory).collect(Collectors.toList());
    }
}
