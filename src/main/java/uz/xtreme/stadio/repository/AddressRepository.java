package uz.xtreme.stadio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.stadio.domain.Address;
import uz.xtreme.stadio.repository.projection.AddressPoint;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a.id AS id, a.lat AS lat, a.lng AS lng FROM Address a")
    List<AddressPoint> findAllAddressPoints();

}
