package uz.xtreme.stadio.service.dto.address;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressCreate {
    @Length(max = 255)
    String region;

    @Length(max = 255)
    String street;

    @Length(max = 255)
    String zipCode;

    @NotNull
    BigDecimal lat;

    @NotNull
    BigDecimal lng;

    @NotNull
    @Length(min = 3, max = 20)
    String categorySlug;

    Set<UUID> imageIds = new HashSet<>();
}
