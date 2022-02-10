package uz.xtreme.stadio.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressTo;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;
import uz.xtreme.stadio.web.vm.address.AddressDetailsVm;

import java.util.List;

@Mapper(uses = {CategoryMapper.class, ImageMapper.class},
        componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "dto.imageIds", target = "images")
    Address asAddress(AddressCreate dto, List<Category> categories);

    AddressTo asDto(Address address);

    void merge(AddressUpdate dto, List<Category> categories, @MappingTarget Address address);

    AddressDetailsVm asAddressDetailsVm(Address addressById);
}
