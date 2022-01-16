package uz.xtreme.stadio.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.xtreme.stadio.domain.Image;
import uz.xtreme.stadio.service.ImageService;
import uz.xtreme.stadio.service.dto.image.ImageTo;
import uz.xtreme.stadio.service.mapper.ImageMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses/{addressId}/images")
public class AddressImageResources {

    private final ImageService service;
    private final ImageMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ImageTo upload(@PathVariable long addressId, MultipartFile file) {
        Image image = service.uploadAddressImage(addressId, file);
        return mapper.asDto(image);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePosition(@PathVariable long addressId, @PathVariable UUID id, @RequestParam int position) {
        service.changeImagePosition(id, addressId, position);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long addressId, @PathVariable UUID id) {
        service.deleteAddressImage(id, addressId);
    }

    @GetMapping
    public List<ImageTo> addressImages(@PathVariable long addressId) {
        return mapper.asDto(service.getAddressImages(addressId));
    }
}
