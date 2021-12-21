package uz.xtreme.stadio.service.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddressUpdate {
    @JsonProperty("region") private String region;
    @JsonProperty("street") private String street;
    @JsonProperty("zip_code") private String zipCode;
    @JsonProperty("lat") private BigDecimal lat;
    @JsonProperty("lon") private BigDecimal lng;
    @JsonProperty("category_slug") private String categorySlug;
}
