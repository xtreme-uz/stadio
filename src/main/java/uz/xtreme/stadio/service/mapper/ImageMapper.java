package uz.xtreme.stadio.service.mapper;

import liquibase.util.file.FilenameUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.xtreme.stadio.domain.Image;
import uz.xtreme.stadio.service.dto.image.ImageTo;
import uz.xtreme.stadio.utils.ImageUtils;
import uz.xtreme.stadio.web.vm.image.ImageTemplateVm;
import uz.xtreme.stadio.web.vm.image.ImageVm;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring",
        imports = {UUID.class, FilenameUtils.class, ImageUtils.class})
public interface ImageMapper {

    @Mapping(target = "link", expression = "java(ImageUtils.getImageLink(image))")
    ImageTo asDto(Image image);

    @Mapping(target = "link", expression = "java(ImageUtils.getImageLink(image))")
    ImageVm asImageVm(Image image);

    List<ImageTo> asDto(List<Image> images);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "ext", expression = "java(FilenameUtils.getExtension(filename))")
    Image asImageTemplate(String filename);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "ext", expression = "java(FilenameUtils.getExtension(filename))")
    @Mapping(target = "position", constant = "0")
    Image asAddressImage(Long addressId, String filename);

    @Mapping(target = "link", expression = "java(ImageUtils.getImageLink(image))")
    ImageTemplateVm asImageTemplateVm(Image image);

    @Mapping(target = "id", source = "uuid")
    Image fromId(UUID uuid);

    List<Image> fromIds(Set<UUID> imageIds);
}
