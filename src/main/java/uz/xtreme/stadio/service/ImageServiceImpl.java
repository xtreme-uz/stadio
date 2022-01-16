package uz.xtreme.stadio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.xtreme.stadio.domain.Image;
import uz.xtreme.stadio.repository.ImageRepository;
import uz.xtreme.stadio.service.mapper.ImageMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;
    private final ImageMapper mapper;

    @Override
    public Image uploadImageTemplate(MultipartFile file) {
        //TODO validate user image template limit
        Image image = mapper.asImageTemplate(file.getOriginalFilename());
        //TODO upload file
        return repository.save(image);
    }

    @Override
    public Image uploadAddressImage(long addressId, MultipartFile file) {
        //TODO validate address image limit
        Image image = mapper.asAddressImage(addressId, file.getOriginalFilename());
        //TODO upload file
        return repository.save(image);
    }

    @Override
    public void changeImagePosition(UUID id, long addressId, int position) {
        Image image = getAddressImageById(id, addressId);
        image.setPosition(position);
        repository.save(image);
    }

    @Override
    public void deleteAddressImage(UUID id, long addressId) {
        Image image = getAddressImageById(id, addressId);
        image.setAddressId(null);
        repository.save(image);
    }

    @Override
    public List<Image> getAddressImages(Long addressId) {
        return repository.findByAddressId(addressId);
    }

    public Image getAddressImageById(UUID id, long addressId) {
        return repository.findByIdAndAddressId(id, addressId)
                .orElseThrow(() -> new RuntimeException("Image not found by id: " + id + " addressId: " + addressId));
    }


}
