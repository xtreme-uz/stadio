package uz.xtreme.stadio.service.mapper;

import org.springframework.stereotype.Component;
import uz.xtreme.stadio.domain.Image;
import uz.xtreme.stadio.service.dto.image.ImageTo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageMapper {

    public ImageTo asDto(Image image) {
        if (image == null)
            return null;

        var result = new ImageTo();

        result.setId(image.getId());
        result.setPosition(image.getPosition());
        result.setAddressId(image.getAddressId());

        return result;
    }

    public List<ImageTo> asDto(List<Image> images) {
        if (images == null)
            return Collections.emptyList();

        return images.stream().map(this::asDto).collect(Collectors.toList());
    }
}
