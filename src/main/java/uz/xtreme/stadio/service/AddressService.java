package uz.xtreme.stadio.service;

import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.service.dto.address.AddressCreate;

public interface AddressService {
    Address create(AddressCreate dto);

    void delete(long id);
}
