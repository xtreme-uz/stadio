package uz.xtreme.stadio.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressTo;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    private final CategoryMapper categoryMapper;
    private final ImageMapper imageMapper;

    public Address asAddress(AddressCreate dto, List<Category> categories) {
        if (dto == null)
            return null;

        var result = new Address();

        result.setRegion(dto.getRegion());
        result.setStreet(dto.getStreet());
        result.setZipCode(dto.getZipCode());
        result.setLat(dto.getLat());
        result.setLon(dto.getLon());

        result.setCategories(categories);

        return result;
    }

    public AddressTo asDto(Address address) {
        if (address == null)
            return null;

        var result = new AddressTo();

        result.setId(address.getId());
        result.setRegion(address.getRegion());
        result.setStreet(address.getStreet());
        result.setZipCode(address.getZipCode());
        result.setLat(address.getLat());
        result.setLon(address.getLon());
        result.setImages(imageMapper.asDto(address.getImages()));
        result.setCategories(categoryMapper.asSingleCategory(address.getCategories()));

        return result;
    }

}
