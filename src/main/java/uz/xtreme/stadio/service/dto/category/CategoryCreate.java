package uz.xtreme.stadio.service.dto.category;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryCreate {

    @NotNull
    @Length(min = 3, max = 20)
    String slug;

    @NotNull
    String name;

    String parentSlug;
}
