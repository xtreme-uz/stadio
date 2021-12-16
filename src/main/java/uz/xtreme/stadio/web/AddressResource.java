package uz.xtreme.stadio.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.service.AddressService;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressTo;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;
import uz.xtreme.stadio.service.mapper.AddressMapper;

import javax.validation.Valid;

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
    public AddressTo update(@PathVariable long id, @RequestBody AddressUpdate dto) {
        Address address = service.update(id, dto);
        return mapper.asDto(address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @GetMapping
    public Page<AddressTo> getAll(Pageable pageable) {
        return mapper.asDto(service.getAll(pageable));
    }

}
