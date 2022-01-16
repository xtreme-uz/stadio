package uz.xtreme.stadio.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.xtreme.stadio.core.validation.Validation;
import uz.xtreme.stadio.core.validation.Validator;
import uz.xtreme.stadio.repository.AddressRepository;
import uz.xtreme.stadio.repository.CategoryRepository;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;
import uz.xtreme.stadio.service.validator.CategoryValidation.LeafCategoryValidator;
import uz.xtreme.stadio.service.validator.ImageValidation.AddressImageLimitValidator;

@Component
@RequiredArgsConstructor
public class AddressValidation implements Validation {

    @Value("${settings.address-images.limit}")
    private Integer addressImagesLimit;

    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;

    public void validateOnCreate(AddressCreate dto) {
        var validator = validate()
                .with(new LeafCategoryValidator(categoryRepository, dto.getCategorySlug()))
                .with(new AddressImageLimitValidator(dto.getImageIds().size(), addressImagesLimit));

        validator.verify();
    }

    public void validateOnUpdate(long addressId, AddressUpdate dto) {
        var validator = validate()
                .with(new AddressExistValidator(addressRepository, addressId))
                .with(new LeafCategoryValidator(categoryRepository, dto.getCategorySlug()));

        validator.verify();
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
}
