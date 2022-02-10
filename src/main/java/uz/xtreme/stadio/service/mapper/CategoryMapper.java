package uz.xtreme.stadio.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.service.dto.category.CategoryCreate;
import uz.xtreme.stadio.service.dto.category.CategoryTo;
import uz.xtreme.stadio.service.dto.category.NestedCategoryTo;
import uz.xtreme.stadio.service.dto.category.SingleCategoryTo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category asCategory(CategoryCreate dto);

    @Mapping(target = "parent", expression = "java(asSingleCategory(category.getParent()))")
    @Mapping(target = "categories", expression = "java(asSingleCategory(category.getCategories()))")
    CategoryTo asDto(Category category);

    @Mapping(target = "categories", expression = "java(asNestedCategory(category.getCategories()))")
    NestedCategoryTo asNestedCategory(Category category);

    List<NestedCategoryTo> asNestedCategory(List<Category> categories);

    @Mapping(target = "parentSlug", source = "parent.slug")
    SingleCategoryTo asSingleCategory(Category category);

    List<SingleCategoryTo> asSingleCategory(List<Category> category);
}
