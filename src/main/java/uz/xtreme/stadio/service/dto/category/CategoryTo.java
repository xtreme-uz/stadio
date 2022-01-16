package uz.xtreme.stadio.service.dto.category;

import lombok.Data;

import java.util.List;

@Data
public class CategoryTo {
    private String slug;
    private String name;
    private SingleCategoryTo parent;
    private List<SingleCategoryTo> categories;
}
