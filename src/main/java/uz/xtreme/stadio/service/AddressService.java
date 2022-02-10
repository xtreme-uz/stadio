package uz.xtreme.stadio.service;

import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.repository.projection.AddressPoint;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;

import java.util.List;

public interface AddressService {
    Address create(AddressCreate dto);

    Address update(long id, AddressUpdate dto);

    void delete(long id);

    List<AddressPoint> getAllAddressPoints();

    Address getAddressById(long id);
}
