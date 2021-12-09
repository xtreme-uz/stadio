package uz.xtreme.stadio.service.dto;

import lombok.Data;

@Data
public class ContentWrapper<T> {

    private T content;

    public ContentWrapper(T content) {
        this.content = content;
    }

    public static <T> ContentWrapper<T> wrap(T content) {
        return new ContentWrapper<>(content);
    }

}
