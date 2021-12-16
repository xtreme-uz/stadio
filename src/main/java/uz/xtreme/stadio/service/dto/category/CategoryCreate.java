package uz.xtreme.stadio.service.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryCreate {
    @NotNull @JsonProperty("slug") private String slug;
    @NotNull @JsonProperty("name") private String name;
    @JsonProperty("parent_slug") private String parentSlug;
}
