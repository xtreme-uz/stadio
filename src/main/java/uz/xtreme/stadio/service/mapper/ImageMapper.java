package uz.xtreme.stadio.service.mapper;

import org.springframework.stereotype.Component;
import uz.xtreme.stadio.domain.Image;
import uz.xtreme.stadio.service.dto.image.ImageTo;
import uz.xtreme.stadio.web.vm.ImageTemplateVm;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;
import static liquibase.util.file.FilenameUtils.getExtension;

@Component
public class ImageMapper {

    public ImageTo asDto(Image image) {
        if (image == null)
            return null;

        var result = new ImageTo();

        result.setId(image.getId());
        result.setPosition(image.getPosition());

        String imageId = image.getId().toString();
        String link = imageId + "." + image.getExt();

        result.setLink(link);

        return result;
    }

    public List<ImageTo> asDto(List<Image> images) {
        if (images == null)
            return Collections.emptyList();

        return images.stream().map(this::asDto).collect(Collectors.toList());
    }

    public Image asImageTemplate(String filename) {
        Image image = new Image();
        image.setId(randomUUID());
        image.setExt(getExtension(filename));

        return image;
    }

    public Image asAddressImage(Long addressId, String filename) {
        if (addressId == null)
            return null;

        Image image = new Image();
        image.setId(randomUUID());
        image.setAddressId(addressId);
        image.setExt(getExtension(filename));

        return image;
    }

    public ImageTemplateVm asImageTemplateVm(Image image) {
        String imageId = image.getId().toString();
        String link = imageId + "." + image.getExt();
        return new ImageTemplateVm(imageId, link);
    }

    public List<Image> fromIds(Set<UUID> imageIds) {
        return imageIds.stream().map(this::fromId)
                .collect(Collectors.toList());
    }

    public Image fromId(UUID uuid) {
        var image = new Image();
        image.setId(uuid);
        return image;
    }
}
