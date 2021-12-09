package uz.xtreme.stadio.service.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryTo {
    @JsonProperty("id") private Long id;
    @JsonProperty("slug") private String slug;
    @JsonProperty("name") private String name;
    @JsonProperty("parent") private CategoryTo parent;
    @JsonProperty("categories") private List<CategoryTo> categories;
}
