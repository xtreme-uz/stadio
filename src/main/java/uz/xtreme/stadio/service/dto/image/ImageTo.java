package uz.xtreme.stadio.service.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class ImageTo {
    @JsonProperty("id") private UUID id;
    @JsonProperty("position") private Integer position;
    @JsonProperty("link") private String link;
}
