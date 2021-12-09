package uz.xtreme.stadio.service.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SingleCategoryTo {
    @JsonProperty("id") private Long id;
    @JsonProperty("slug") private String slug;
    @JsonProperty("name") private String name;
    @JsonProperty("parent_id") private Long parentId;
}
