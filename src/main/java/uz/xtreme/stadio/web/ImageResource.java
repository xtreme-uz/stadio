package uz.xtreme.stadio.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.xtreme.stadio.domain.Image;
import uz.xtreme.stadio.service.ImageService;
import uz.xtreme.stadio.service.mapper.ImageMapper;
import uz.xtreme.stadio.web.vm.ImageTemplateVm;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses/images")
public class ImageResource {

    private final ImageService service;
    private final ImageMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ImageTemplateVm upload(MultipartFile file) {
        Image image = service.uploadImageTemplate(file);
        return mapper.asImageTemplateVm(image);
    }

}
