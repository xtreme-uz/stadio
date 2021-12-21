package uz.xtreme.stadio.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import uz.xtreme.stadio.core.validation.Validation;
import uz.xtreme.stadio.core.validation.Validator;
import uz.xtreme.stadio.repository.AddressRepository;
import uz.xtreme.stadio.repository.CategoryRepository;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;

@Component
@RequiredArgsConstructor
public class AddressValidation implements Validation {

    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;

    public void validateOnCreate(AddressCreate dto) {
        validate()
                .with(new LeafCategoryValidator(categoryRepository, dto.getCategorySlug()))
                .verify();
    }

    public void validateOnUpdate(long addressSlug, AddressUpdate dto) {
        validate()
                .with(new AddressExistValidator(addressRepository, addressSlug))
                .with(new LeafCategoryValidator(categoryRepository, dto.getCategorySlug()))
                .verify();
    }

    @RequiredArgsConstructor
    static class AddressExistValidator extends Validator {
        private final AddressRepository repository;
        private final long addressId;
        @Override
        public void verify() {
            if (!repository.existsById(addressId))
                throw new RuntimeException("Address with id: " + addressId + " not exists.");

            verifyNext();
        }
    }

    @RequiredArgsConstructor
    static class LeafCategoryValidator extends Validator {
        private final CategoryRepository repository;
        private final String categorySlug;

        @Override
        public void verify() {
            var category = repository.findById(categorySlug)
                    .orElseThrow(() -> new RuntimeException("Category not found by id"));

            if (!CollectionUtils.isEmpty(category.getCategories()))
                throw new RuntimeException("Category is not leaf");

            verifyNext();
        }
    }
}
