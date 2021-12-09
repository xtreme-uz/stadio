package uz.xtreme.stadio.service.exception;

import lombok.Getter;

@Getter
public final class CategoryNotFoundByIdException extends RuntimeException {

    private static final long serialVersionUID = -7279563359129071161L;
    private final long id;

    public CategoryNotFoundByIdException(long id) {
        super(String.format("Category not found by id: %d", id));
        this.id = id;
    }
}
