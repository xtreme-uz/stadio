package uz.xtreme.stadio.utils;

import uz.xtreme.stadio.domain.Image;

public class ImageUtils {

    private ImageUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getImageLink(Image image) {
        return String.format("%s.%s", image.getId(), image.getExt());
    }

}
