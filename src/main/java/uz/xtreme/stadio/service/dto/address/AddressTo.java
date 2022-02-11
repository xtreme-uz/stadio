package uz.xtreme.stadio.service.dto.address;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class AddressTo {
    Long id;
    String region;
    String street;
    String zipCode;
    BigDecimal lat;
    BigDecimal lng;
}
