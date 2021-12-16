package uz.xtreme.stadio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;

public interface AddressService {
    Address create(AddressCreate dto);

    Address update(long id, AddressUpdate dto);

    void delete(long id);

    Page<Address> getAll(Pageable pageable);
}
