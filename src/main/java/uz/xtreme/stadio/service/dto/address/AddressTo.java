package uz.xtreme.stadio.service.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import uz.xtreme.stadio.service.dto.category.SingleCategoryTo;
import uz.xtreme.stadio.service.dto.image.ImageTo;

import java.util.List;

@Data
public class AddressTo {
    @JsonProperty("id") private Long id;
    @JsonProperty("region") private String region;
    @JsonProperty("street") private String street;
    @JsonProperty("zip_code") private String zipCode;
    @JsonProperty("lat") private String lat;
    @JsonProperty("lon") private String lon;
    @JsonProperty("images") private List<ImageTo> images;
    @JsonProperty("categories") private List<SingleCategoryTo> categories;
}
