package uz.xtreme.stadio.repository.projection;

import java.math.BigDecimal;

public interface AddressPoint {
    Long getId();
    BigDecimal getLat();
    BigDecimal getLng();
}
