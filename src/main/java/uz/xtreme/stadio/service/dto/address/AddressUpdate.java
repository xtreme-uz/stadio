package uz.xtreme.stadio.service.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressUpdate {
    @JsonProperty("region") private String region; //required validator
    @JsonProperty("street") private String street;
    @JsonProperty("zip_code") private String zipCode;
    @JsonProperty("lat") private String lat;
    @JsonProperty("lon") private String lon;
    @JsonProperty("category_slug") private String categorySlug;
}
