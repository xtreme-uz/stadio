package uz.xtreme.stadio.web.vm.image;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;

import java.util.UUID;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ImageVm {
    UUID id;
    Integer position;
    String link;
}
