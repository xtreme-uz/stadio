package uz.xtreme.stadio.service.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressCreate {
    @JsonProperty("region") private String region; //required validator
    @JsonProperty("street") private String street;
    @JsonProperty("zip_code") private String zipCode;
    @JsonProperty("lat") private String lat;
    @JsonProperty("lon") private String lon;

    //TODO image ids
    @NotNull
    @JsonProperty("category_id") private Long categoryId;
}
