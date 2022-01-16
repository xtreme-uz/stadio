package uz.xtreme.stadio.service;

import org.springframework.web.multipart.MultipartFile;
import uz.xtreme.stadio.domain.Image;

import java.util.List;
import java.util.UUID;

public interface ImageService {
    Image uploadImageTemplate(MultipartFile file);

    Image uploadAddressImage(long addressId, MultipartFile file);

    void changeImagePosition(UUID id, long addressId, int position);

    void deleteAddressImage(UUID id, long addressId);

    List<Image> getAddressImages(Long addressId);
}
