package uz.xtreme.stadio.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.service.CategoryService;
import uz.xtreme.stadio.service.dto.ContentWrapper;
import uz.xtreme.stadio.service.dto.category.CategoryCreate;
import uz.xtreme.stadio.service.dto.category.CategoryTo;
import uz.xtreme.stadio.service.dto.category.NestedCategoryTo;
import uz.xtreme.stadio.service.mapper.CategoryMapper;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryResource {

    private final CategoryService service;
    private final CategoryMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryTo create(@Valid @RequestBody CategoryCreate dto) {
        Category category = service.createCategory(dto);
        return mapper.asDto(category);
    }

    @GetMapping
    public ContentWrapper<List<NestedCategoryTo>> categoriesTree() {
        var tree = service.categoriesTree();
        var result = mapper.asNestedCategory(tree);
        return ContentWrapper.wrap(result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.deleteCategory(id);
    }

}
