package uz.xtreme.stadio.service.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AddressCreate {
    @Length(max = 255)
    @JsonProperty("region")
    private String region;

    @Length(max = 255)
    @JsonProperty("street")
    private String street;

    @Length(max = 255)
    @JsonProperty("zip_code")
    private String zipCode;

    @JsonProperty("lat")
    private BigDecimal lat;

    @JsonProperty("lng")
    private BigDecimal lng;

    @NotNull
    @Length(max = 255)
    @JsonProperty("category_slug")
    private String categorySlug;
}
