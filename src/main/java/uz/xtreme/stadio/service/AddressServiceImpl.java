package uz.xtreme.stadio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.repository.AddressRepository;
import uz.xtreme.stadio.service.dto.address.AddressCreate;
import uz.xtreme.stadio.service.dto.address.AddressUpdate;
import uz.xtreme.stadio.service.mapper.AddressMapper;
import uz.xtreme.stadio.utils.CategoryUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final CategoryService categoryService;
    private final AddressMapper mapper;

    @Override
    public Address create(AddressCreate dto) {
        Category category = categoryService.getBySlug(dto.getCategorySlug());
        validateLeafCategory(category);
        //TODO validate images count

        //TODO add images
        List<Category> categories = CategoryUtils.extractParents(category);
        Address address = mapper.asAddress(dto, categories);
        return repository.save(address);
    }

    @Override
    public Address update(long id, AddressUpdate dto) {
        List<Category> categories = null;

        if (dto.getCategorySlug() != null) {
            Category category = categoryService.getBySlug(dto.getCategorySlug());
            validateLeafCategory(category);
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
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Address not found by id: " + id));
    }

    private void validateLeafCategory(Category category) {
        if (!CollectionUtils.isEmpty(category.getCategories()))
            throw new RuntimeException("Category is not leaf");
    }

}
