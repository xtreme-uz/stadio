package uz.xtreme.stadio.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.repository.projection.AddressPoint;
import uz.xtreme.stadio.service.AddressService;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressTo;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;
import uz.xtreme.stadio.service.mapper.AddressMapper;
import uz.xtreme.stadio.web.vm.address.AddressDetailsVm;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressResource {

    private final AddressService service;
    private final AddressMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressTo create(@Valid @RequestBody AddressCreate dto) {
        Address address = service.create(dto);
        return mapper.asDto(address);
    }

    @PatchMapping("/{id}")
    public AddressTo update(@PathVariable long id, @Valid @RequestBody AddressUpdate dto) {
        Address address = service.update(id, dto);
        return mapper.asDto(address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/details")
    public AddressDetailsVm getAddressDetailsById(@PathVariable long id) {
        return mapper.asAddressDetailsVm(service.getAddressById(id));
    }

    @GetMapping("/as-points")
    public List<AddressPoint> getAllAddressPoints() {
        return service.getAllAddressPoints();
    }

}
