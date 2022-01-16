package uz.xtreme.stadio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.repository.AddressRepository;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;
import uz.xtreme.stadio.service.mapper.AddressMapper;
import uz.xtreme.stadio.service.validator.AddressValidation;
import uz.xtreme.stadio.utils.CategoryUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final CategoryService categoryService;
    private final AddressMapper mapper;
    private final AddressValidation validation;

    @Override
    public Address create(AddressCreate dto) {
        validation.validateOnCreate(dto);

        Category category = categoryService.getBySlug(dto.getCategorySlug());
        List<Category> categories = CategoryUtils.extractParents(category);
        Address address = mapper.asAddress(dto, categories);

        return repository.save(address);
    }

    @Override
    public Address update(long id, AddressUpdate dto) {
        validation.validateOnUpdate(id, dto);

        List<Category> categories = null;

        if (dto.getCategorySlug() != null) {
            Category category = categoryService.getBySlug(dto.getCategorySlug());
            categories = CategoryUtils.extractParents(category);
        }

        Address address = get(id);
        mapper.merge(dto, categories, address);
        return repository.save(address);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Address> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Address get(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found by id: " + id));
    }

}
