package uz.xtreme.stadio.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressTo;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;

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
        result.setLng(dto.getLng());
        result.setImages(imageMapper.fromIds(dto.getImageIds()));

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
        result.setLng(address.getLng());
        result.setImages(imageMapper.asDto(address.getImages()));
        result.setCategories(categoryMapper.asSingleCategory(address.getCategories()));

        return result;
    }

    public Page<AddressTo> asDto(Page<Address> addresses) {
        if (addresses == null)
            return null;

        return addresses.map(this::asDto);
    }

    public void merge(AddressUpdate dto, List<Category> categories, Address address) {
        if (dto == null || address == null)
            return;

        if (dto.getRegion() != null)
            address.setRegion(dto.getRegion());

        if (dto.getStreet() != null)
            address.setStreet(dto.getStreet());

        if (dto.getZipCode() != null)
            address.setZipCode(dto.getZipCode());

        if (dto.getLat() != null)
            address.setLat(dto.getLat());

        if (dto.getLng() != null)
            address.setLng(dto.getLng());

        if (categories != null)
            address.setCategories(categories);
    }
}
