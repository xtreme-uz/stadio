package uz.xtreme.stadio.service.dto.address;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressUpdate {
    @Length(max = 255)
    String region;

    @Length(max = 255)
    String street;

    @Length(max = 255)
    String zipCode;

    BigDecimal lat;

    BigDecimal lng;

    @Length(max = 4000)
    String description;

    @Length(min = 3, max = 20)
    String categorySlug;
}
