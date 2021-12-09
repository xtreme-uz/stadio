package uz.xtreme.stadio.service.error;

import lombok.Getter;

@Getter
public final class CategoryNotFoundByIdError extends Error {

    private final long id;

    public CategoryNotFoundByIdError(long id) {
        super(ErrorType.NOT_FOUND, "error.category.not_found.by_id");
        this.id = id;
    }
}
