package uz.xtreme.stadio.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.xtreme.stadio.core.validation.Validation;
import uz.xtreme.stadio.core.validation.Validator;
import uz.xtreme.stadio.repository.CategoryRepository;
import uz.xtreme.stadio.service.dto.category.CategoryCreate;

@Component
@RequiredArgsConstructor
public class CategoryValidation implements Validation {

    private final CategoryRepository categoryRepository;

    public void validateOnCreate(CategoryCreate dto) {
        validate()
                .with(new SlugUniqueValidator(categoryRepository, dto.getSlug()))
                .verify();
    }

    @RequiredArgsConstructor
    static class SlugUniqueValidator extends Validator {
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

}
