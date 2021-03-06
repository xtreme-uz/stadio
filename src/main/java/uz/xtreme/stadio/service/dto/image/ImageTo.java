package uz.xtreme.stadio.service.dto.image;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;

import java.util.UUID;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ImageTo {
    UUID id;
    Integer position;
    String link;
}
