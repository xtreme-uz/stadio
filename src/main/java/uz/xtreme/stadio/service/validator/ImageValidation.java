package uz.xtreme.stadio.service.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.xtreme.stadio.core.validation.Validation;
import uz.xtreme.stadio.core.validation.Validator;
import uz.xtreme.stadio.repository.ImageRepository;

@Component
@RequiredArgsConstructor
public class ImageValidation implements Validation {

    public static class AddressImageLimitValidator extends Validator {

        private final Integer addressImagesLimit;
        private Integer addressImagesCount;
        private Long addressId;
        private ImageRepository imageRepository;

        public AddressImageLimitValidator(Integer addressImagesCount, Integer addressImagesLimit) {
            this.addressImagesCount = addressImagesCount;
            this.addressImagesLimit = addressImagesLimit;
        }

        public AddressImageLimitValidator(Integer addressImagesLimit, Long addressId, ImageRepository imageRepository) {
            this.addressImagesLimit = addressImagesLimit;
            this.addressId = addressId;
            this.imageRepository = imageRepository;
        }

        @Override
        public void verify() {
            int count;

            if (addressId == null)
                count = addressImagesCount;
            else
                count = imageRepository.countByAddressId(addressId);

            if (count + 1 > addressImagesLimit)
                throw new RuntimeException("Address images out of limit");

            verifyNext();
        }
    }

}
