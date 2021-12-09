package uz.xtreme.stadio.utils;

import uz.xtreme.stadio.domain.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryUtils {

    private CategoryUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method collects a given category and all the above parent categories into a list
     *
     * @param category given category
     * @return list of given category and all the above parent categories
     */
    public static List<Category> extractParents(Category category) {
        if (category == null)
            return Collections.emptyList();

        List<Category> categories = new ArrayList<>();
        categories.add(category);

        var parent = category.getParent();
        while (parent != null){
            categories.add(parent);
            parent = parent.getParent();
        }

        return categories;
    }

}
