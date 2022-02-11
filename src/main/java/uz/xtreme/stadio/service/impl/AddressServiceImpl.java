package uz.xtreme.stadio.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.domain.User;
import uz.xtreme.stadio.repository.AddressRepository;
import uz.xtreme.stadio.repository.CategoryRepository;
import uz.xtreme.stadio.repository.UserRepository;
import uz.xtreme.stadio.repository.projection.AddressPoint;
import uz.xtreme.stadio.service.AddressService;
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
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final AddressMapper mapper;
    private final AddressValidation validation;

    @Override
    public Address create(AddressCreate dto) {
        validation.validateOnCreate(dto);

        User user = userRepository.findByUsername("admin").orElse(null);
        Category category = categoryRepository.getById(dto.getCategorySlug());
        List<Category> categories = CategoryUtils.extractParents(category);
        Address address = mapper.asAddress(dto, user, categories);

        return repository.save(address);
    }

    @Override
    public Address update(long id, AddressUpdate dto) {
        validation.validateOnUpdate(id, dto);

        List<Category> categories = null;

        if (dto.getCategorySlug() != null) {
            Category category = categoryRepository.getById(dto.getCategorySlug());
            categories = CategoryUtils.extractParents(category);
        }

        Address address = getAddressById(id);
        mapper.merge(dto, categories, address);
        return repository.save(address);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AddressPoint> getAllAddressPoints() {
        return repository.findAllAddressPoints();
    }

    @Override
    public Address getAddressById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Address not found by id: " + id));
    }

}
