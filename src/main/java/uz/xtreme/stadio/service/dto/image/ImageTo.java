package uz.xtreme.stadio.service.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class ImageTo {
    @JsonProperty("id") private UUID id;
    @JsonProperty("position") private int position;
    @JsonProperty("address_id") private Long addressId;
}
