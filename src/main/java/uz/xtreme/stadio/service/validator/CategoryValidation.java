package uz.xtreme.stadio.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import uz.xtreme.stadio.core.validation.Validation;
import uz.xtreme.stadio.core.validation.Validator;
import uz.xtreme.stadio.repository.CategoryRepository;
import uz.xtreme.stadio.service.dto.category.CategoryCreate;

@Component
@RequiredArgsConstructor
public class CategoryValidation implements Validation {

    private final CategoryRepository categoryRepository;

    public void validateOnCreate(CategoryCreate dto) {
        var validator = validate()
                .with(new SlugSyntaxValidator(dto.getSlug()))
                .with(new SlugUniqueValidator(categoryRepository, dto.getSlug()));

        validator.verify();
    }

    @RequiredArgsConstructor
    public static class SlugUniqueValidator extends Validator {
        private final CategoryRepository categoryRepository;
        private final String categorySlug;

        @Override
        public void verify() {
            if (categoryRepository.existsBySlug(categorySlug)) {
                throw new RuntimeException("Slug unique constraint");
            }

            verifyNext();
        }
    }

    @RequiredArgsConstructor
    public static class SlugSyntaxValidator extends Validator {
        private final String categorySlug;

        @Override
        public void verify() {
            if (StringUtils.containsWhitespace(categorySlug))
                throw new RuntimeException("Slug cannot contain white space");
        }
    }

    @RequiredArgsConstructor
    public static class LeafCategoryValidator extends Validator {
        private final CategoryRepository repository;
        private final String categorySlug;

        @Override
        public void verify() {
            if (categorySlug != null) {
                var category = repository.findById(categorySlug)
                        .orElseThrow(() -> new RuntimeException("Category not found by id"));

                if (!CollectionUtils.isEmpty(category.getCategories()))
                    throw new RuntimeException("Category is not leaf");
            }

            verifyNext();
        }
    }

}
