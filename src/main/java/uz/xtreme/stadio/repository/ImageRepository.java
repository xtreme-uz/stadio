package uz.xtreme.stadio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.stadio.domain.Image;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface ImageRepository extends JpaRepository<Image, UUID> {

    @Query("FROM Image t WHERE t.addressId = :addressId ORDER BY t.position")
    List<Image> findByAddressId(Long addressId);

    Optional<Image> findByIdAndAddressId(UUID id, Long addressId);

    int countByAddressId(Long addressId);

}
