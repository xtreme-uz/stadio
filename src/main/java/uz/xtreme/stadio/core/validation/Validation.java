package uz.xtreme.stadio.core.validation;

public interface Validation {
    default EmptyValidator validate() {
        return new EmptyValidator();
    }
}
