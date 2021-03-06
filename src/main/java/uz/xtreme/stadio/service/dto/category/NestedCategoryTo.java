package uz.xtreme.stadio.service.dto.category;

import lombok.Data;

import java.util.List;

@Data
public class NestedCategoryTo {
    private String slug;
    private String name;
    private List<NestedCategoryTo> categories;
}
