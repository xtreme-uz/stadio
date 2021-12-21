package uz.xtreme.stadio.core.validation;

public class EmptyValidator extends Validator{
    @Override
    public void verify() {
        verifyNext();
    }
}
